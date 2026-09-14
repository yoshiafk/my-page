pipeline {
  agent any

  /*
   * Parameter allows manual invocation of the pipeline with a specific
   * git tag; if supplied the job will build the project and publish a
   * GitHub release using that tag.  Leaving it blank will skip the
   * release stage.
   */
  parameters {
    string(name: 'RELEASE_TAG', defaultValue: '', description: 'Optional git tag (e.g. v1.2.3) to publish as a GitHub release')
  }

  options {
    skipDefaultCheckout(true) // avoid duplicate SCM checkout
  }

  environment {
    TARGET_NS                 = 'digital-my-page'
    APP_NAME                  = 'my-page-liferay'
    BC_NAME                   = "${APP_NAME}"
    KUBE_CRED_ID              = 'jenkins-dev-axa-magi-id-kubeconfig'
    GITHUB_CRED               = 'github-ssh-prod'
    ARTIFACTORY_CRED_ID       = 'generic-artifatory-maven'
    SONAR_PROJECT_KEY         = 'aii.mypage-liferay'
    SONAR_EXCLUSIONS          = '**/build/**,**/gradle/**,**/TestResults/**,**/src/test/**,**/*Test.java,**/*IT.java,**/node_modules/**,**/dist/**,**/*.min.js,**/*.min.css,**/*.map,**/target/**,**/*-api/**/src/main/java/**,**/modules/**/**/service/base/**,**/modules/**/**/service/persistence/**,**/themes/**/src/**/dist/**,**/themes/**/node_modules/**'
    SONAR_COVERAGE_EXCLUSIONS = '**/entities/**,**/models/**,**/migrations/**' 
    SONAR_CPD_EXCLUSIONS      = 'modules/**/src/main/java/generated/**'
    SONAR_COVERAGE            = '**/jacoco/test/jacocoTestReport.xml,**/build/reports/jacoco/**/*.xml'
    SONAR_TEST_EXCLUSIONS     = '**/src/test/**,**/*Test.java,**/*IT.java'
    SONAR_TIMEOUT             = '120'
    GRADLE_HOME               = tool('gradle')
    PATH                      = "${GRADLE_HOME}/bin:${env.PATH}"
    // SSL truststore file doesn't exist on Jenkins pod - removed broken reference
    // Using HTTP fallback in build.gradle until DevOps adds Artifactory cert to Java cacerts
    GRADLE_OPTS               = "-Xmx2g -Dfile.encoding=UTF-8"
    TZ                        = "Asia/Singapore"
    SHOW_VERBOSE_LOGS         = 'true'
  }

  stages {
    stage('📥 Checkout Code') {
      steps {
        script {
          echo "==========================================="
          echo "📥 CODE CHECKOUT STARTED: ${new Date().format('yyyy-MM-dd HH:mm:ss')}"
          echo "   Branch: ${env.BRANCH_NAME}"
          echo "   Repository: git@github.axa.com:aii/my-page-liferay.git"
          echo "==========================================="
        }
        
        checkout([
          $class: 'GitSCM',
          branches: [[name: "*/${env.BRANCH_NAME}"]],
          userRemoteConfigs: [[
            url: 'git@github.axa.com:aii/my-page-liferay.git',
            credentialsId: env.GITHUB_CRED
          ]]
        ])
        script {
          echo "✅ Code checkout completed successfully"
          echo ""
        }
      }
    }

    stage('📦 Restore Dependencies') {
      steps {
        script {
          echo "==========================================="
          echo "📦 DEPENDENCY CONFIGURATION STARTED: ${new Date().format('yyyy-MM-dd HH:mm:ss')}"
          echo "==========================================="
        }
        withCredentials([usernamePassword(
          credentialsId: env.ARTIFACTORY_CRED_ID,
          usernameVariable: 'ART_USER',
          passwordVariable: 'ART_PASSWORD'
        )]) {
          sh '''
            set -eux
            echo "📝 Configuring Gradle properties for Artifactory access..."
            echo ""

            # Backup existing gradle.properties if not already backed up
            if [ ! -f gradle.properties.original ]; then
              cp gradle.properties gradle.properties.original
              echo "✅ Backed up original gradle.properties"
            fi

            # Restore from backup to ensure clean state
            cp gradle.properties.original gradle.properties
            
            echo "📝 Gradle properties restored (no SSL truststore modification - file doesn't exist)"
            echo "   Using HTTP fallback repositories in build.gradle until DevOps adds cert"
            echo ""
            
            # Append Artifactory credentials (with blank line separator)
            echo "" >> gradle.properties
            echo "# Artifactory Authentication (Jenkins)" >> gradle.properties
            echo "artifactory_user=${ART_USER}" >> gradle.properties
            echo "artifactory_password=${ART_PASSWORD}" >> gradle.properties
            
            echo "✅ gradle.properties configured successfully"
            echo ""
          '''
        }
        
        script {
          echo "✅ Dependency configuration completed successfully"
          echo ""
        }
      }
    }

    stage('⚙️ Build and Test') {
      steps {
        withCredentials([usernamePassword(
          credentialsId: env.ARTIFACTORY_CRED_ID,
          usernameVariable: 'ART_USER',
          passwordVariable: 'ART_PASSWORD'
        )]) {
          sh '''
            set -eux
            
            echo "==========================================="
            echo "⚙️  BUILD STARTED: $(date '+%Y-%m-%d %H:%M:%S')"
            echo "==========================================="
            
            echo "📋 Environment: TZ=${TZ} | Java: $(java -version 2>&1 | head -n 1) | Gradle: $(gradle --version | grep Gradle) | SHOW_VERBOSE_LOGS=${SHOW_VERBOSE_LOGS}"
            echo ""
            
            echo "🏗️  Starting Gradle build with tests and coverage..."
            echo "   Flags: --parallel --build-cache | SHOW_VERBOSE_LOGS=${SHOW_VERBOSE_LOGS}"
            echo "   Estimated time: First build ~2-3 hours, subsequent ~15-30 min"
            echo ""
            
            START_TIME=$(date +%s)

            if [ "${SHOW_VERBOSE_LOGS}" = "true" ]; then
              gradle --no-daemon build --parallel --build-cache --info \
                -Dartifactory_user="${ART_USER}" \
                -Dartifactory_password="${ART_PASSWORD}" \
                2>&1 | tee build.log || { echo "Gradle build failed — last 200 lines of build.log:"; tail -n 200 build.log; exit 1; }
            else
              gradle --no-daemon build --parallel --build-cache \
                -Dartifactory_password="${ART_PASSWORD}" \
                > build.log 2>&1 || { echo "Gradle build failed — last 200 lines of build.log:"; tail -n 200 build.log; exit 1; }
            fi

            END_TIME=$(date +%s)
            BUILD_DURATION=$((END_TIME - START_TIME))
            BUILD_MINUTES=$((BUILD_DURATION / 60))
            BUILD_SECONDS=$((BUILD_DURATION % 60))
            
            echo ""
            echo "==========================================="
            echo "✅ BUILD COMPLETED: $(date '+%Y-%m-%d %H:%M:%S')"
            echo "⏱️  Duration: ${BUILD_MINUTES}m ${BUILD_SECONDS}s"
            echo "==========================================="
            echo ""
            
            # Detailed coverage report analysis
            echo "📊 Test Coverage Analysis:"
            echo "==========================================="
            REPORT_COUNT=$(find . -path "*/build/reports/jacoco/test/jacocoTestReport.xml" -type f | wc -l)
            echo "✓ Total JaCoCo XML reports generated: ${REPORT_COUNT}"
            
            if [ ${REPORT_COUNT} -gt 0 ]; then
              echo ""
              echo "📄 Coverage reports found: ${REPORT_COUNT} (details archived in build artifacts)"
              TEST_COUNT=$(find . -path "*/build/test-results/test/*.xml" -type f | wc -l)
              echo "   ├─ Test result files: ${TEST_COUNT}"
              echo "   ├─ Modules with tests: ${REPORT_COUNT}"
              echo "   └─ Ready for SonarQube analysis"
            else
              echo "⚠️  No coverage reports found (all modules may have NO-SOURCE for tests)"
            fi
            
            echo ""
            echo "==========================================="
          '''
        }
      }
      post {
        always {
          script {
            echo "📦 Publishing test results and artifacts..."
          }
          
          // Publish test results - Gradle uses 'test-results/test' not 'TestResults'
          junit allowEmptyResults: true, testResults: '**/build/test-results/test/*.xml'
          
          // Archive coverage reports for SonarQube
          archiveArtifacts allowEmptyArchive: true, artifacts: '**/build/reports/jacoco/test/jacocoTestReport.xml'
          
          // Archive build & sonar logs for detailed troubleshooting
          archiveArtifacts allowEmptyArchive: true, artifacts: 'build.log, sonar.log'
          
          script {
            echo "✅ Test results and coverage reports published"
          }
        }
      }
    }

    stage('🔍 SonarQube Analysis') {
      steps {
        withSonarQubeEnv('SonarQube') {
          withCredentials([usernamePassword(
            credentialsId: env.ARTIFACTORY_CRED_ID,
            usernameVariable: 'ART_USER',
            passwordVariable: 'ART_PASSWORD'
          )]) {
            script {
              // Extract Sonar project version from CHANGELOG.md using Groovy (safer than shell regex)
              def changelog = fileExists('CHANGELOG.md') ? readFile('CHANGELOG.md') : ''
              def matcher = (changelog =~ /(?m)^## \[(?!Unreleased)([^\]]+)\]/)
              env.SONAR_PROJECT_VERSION = matcher ? matcher[0][1] : 'not-provided'
              echo "🔖 Sonar project version: ${env.SONAR_PROJECT_VERSION}"
            }
            sh '''
              set -eux
              
              echo "==========================================="
              echo "🔍 SONARQUBE ANALYSIS STARTED: $(date '+%Y-%m-%d %H:%M:%S')"
              echo "==========================================="
              
              echo "📋 SonarQube Configuration:"
              echo "   GRADLE_OPTS: ${GRADLE_OPTS}"
              echo "   Project Key: ${SONAR_PROJECT_KEY}"
              echo "   Exclusions: ${SONAR_EXCLUSIONS}"
              echo "   Socket Timeout: ${SONAR_TIMEOUT}s"
              echo ""
              
              SONAR_START=$(date +%s)

              # SONAR_PROJECT_VERSION is injected into env by the Groovy script block above
              echo "🔖 Sonar project version: ${SONAR_PROJECT_VERSION}"

              SONAR_COVERAGE_PATHS=$(find modules -path '*/build/reports/jacoco/*' -name '*.xml' -type f | paste -sd, -)
              if [ -z "${SONAR_COVERAGE_PATHS}" ]; then
                SONAR_COVERAGE_PATHS='**/build/reports/jacoco/**/*.xml'
                echo "⚠️  No concrete JaCoCo XML paths found; using fallback glob"
              else
                echo "✅ JaCoCo XML reports detected for Sonar import"
              fi

              if [ "${SHOW_VERBOSE_LOGS}" = "true" ]; then
                gradle --no-daemon sonar --info \
                  -Dartifactory_user="${ART_USER}" \
                  -Dartifactory_password="${ART_PASSWORD}" \
                  -Dsonar.projectKey="${SONAR_PROJECT_KEY}" \
                  -Dsonar.projectName="${APP_NAME}" \
                  -Dsonar.projectVersion="${SONAR_PROJECT_VERSION}" \
                  -Dsonar.exclusions="${SONAR_EXCLUSIONS}" \
                  -Dsonar.test.exclusions="${SONAR_TEST_EXCLUSIONS}" \
                  -Dsonar.coverage.exclusions="${SONAR_COVERAGE_EXCLUSIONS}" \
                  -Dsonar.coverage.jacoco.xmlReportPaths="${SONAR_COVERAGE_PATHS}" \
                  -Dsonar.cpd.exclusions="${SONAR_CPD_EXCLUSIONS}" \
                  -Dsonar.scanner.socketTimeout="${SONAR_TIMEOUT}" \
                  2>&1 | tee sonar.log || { echo "SonarQube analysis failed — last 200 lines of sonar.log:"; tail -n 200 sonar.log; exit 1; }
              else
                gradle --no-daemon sonar \
                  -Dartifactory_user="${ART_USER}" \
                  -Dartifactory_password="${ART_PASSWORD}" \
                  -Dsonar.projectKey="${SONAR_PROJECT_KEY}" \
                  -Dsonar.projectName="${APP_NAME}" \
                  -Dsonar.projectVersion="${SONAR_PROJECT_VERSION}" \
                  -Dsonar.exclusions="${SONAR_EXCLUSIONS}" \
                  -Dsonar.test.exclusions="${SONAR_TEST_EXCLUSIONS}" \
                  -Dsonar.coverage.exclusions="${SONAR_COVERAGE_EXCLUSIONS}" \
                  -Dsonar.coverage.jacoco.xmlReportPaths="${SONAR_COVERAGE_PATHS}" \
                  -Dsonar.cpd.exclusions="${SONAR_CPD_EXCLUSIONS}" \
                  -Dsonar.scanner.socketTimeout="${SONAR_TIMEOUT}" \
                  > sonar.log 2>&1 || { echo "SonarQube analysis failed — last 200 lines of sonar.log:"; tail -n 200 sonar.log; exit 1; }
              fi

              SONAR_END=$(date +%s)
              SONAR_DURATION=$((SONAR_END - SONAR_START))
              SONAR_MINUTES=$((SONAR_DURATION / 60))
              SONAR_SECONDS=$((SONAR_DURATION % 60))
              
              echo ""
              echo "==========================================="
              echo "✅ SONARQUBE ANALYSIS COMPLETED: $(date '+%Y-%m-%d %H:%M:%S')"
              echo "⏱️  Duration: ${SONAR_MINUTES}m ${SONAR_SECONDS}s"
              echo "==========================================="
            '''
          }
        }
      }
    }

    stage('🚦 Verify Quality Gate') {
      steps {
        timeout(time: 2, unit: 'MINUTES') {
          script {
            echo "==========================================="
            echo "🚦 QUALITY GATE CHECK STARTED: ${new Date().format('yyyy-MM-dd HH:mm:ss')}"
            echo "==========================================="
            echo "⏳ Waiting for SonarQube Quality Gate result..."
            echo ""
            
            def qg = waitForQualityGate()
            
            echo ""
            echo "==========================================="
            echo "📊 Quality Gate Result: ${qg.status}"
            echo "==========================================="
            
            if (qg.status != 'OK') {
              echo "❌ Quality Gate Status: FAILED"
              echo "🔗 Check SonarQube dashboard for detailed metrics"
              error "🚨 Quality Gate failed: ${qg.status}. See SonarQube for details."
            } else {
              echo "✅ Quality Gate Status: PASSED"
              echo "🎉 All quality metrics meet the required thresholds"
            }
          }
        }
      }
    }

    // ---------------------------------------------------------
    // optional release stage (runs only when RELEASE_TAG set)
    // ---------------------------------------------------------
    stage('🏷️ Publish Release Artifacts') {
      when {
        expression { return params.RELEASE_TAG?.trim() }
      }
      steps {
        script {
          echo "📦 Building release bundle for tag ${params.RELEASE_TAG}"
        }
        sh '''
          set -eux
          # create zip containing war/jar artifacts; releaseVersion strips leading 'v'
          TAG=${RELEASE_TAG#v}
          ./gradlew -PreleaseVersion=${TAG} releaseBundle
        '''

        // upload bundle to Artifactory
        withCredentials([usernamePassword(
            credentialsId: env.ARTIFACTORY_CRED_ID,
            usernameVariable: 'ART_USER',
            passwordVariable: 'ART_PASSWORD'
        )]) {
          sh '''
            set -eux
            ART_URL="https://artifactory.asia.axa-cloud.com/artifactory/axa-magi-id_main"
            FILE="build/release/my-page-liferay-${RELEASE_TAG#v}.zip"
            echo "📤 Uploading ${FILE} to Artifactory"
            curl -u${ART_USER}:${ART_PASSWORD} \
                 -T "${FILE}" \
                 "${ART_URL}/my-page-liferay-${RELEASE_TAG#v}.zip"
          '''
          echo "✅ Artifact pushed to Artifactory"
        }
      }
      post {
        success {
          echo "✅ Release bundle ${params.RELEASE_TAG} uploaded to Artifactory"
        }
        failure {
          echo "⚠️ Release stage failed; check build log and credentials"
        }
      }
    }
  }

  post {
    success {
      echo "🎉 ${env.APP_NAME} successfully scanned, passed Quality Gate, built, and tests run with coverage."
    }
    failure {
      echo "🚨 Pipeline failed; check logs above for details."
    }
  }
}
