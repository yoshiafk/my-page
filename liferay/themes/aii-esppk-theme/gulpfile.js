'use strict';

require('dotenv').config();
const gulp = require('gulp');
const { exec } = require('child_process');
const liferayThemeTasks = require('liferay-theme-tasks');

// Daftarkan task bawaan Liferay terlebih dahulu
liferayThemeTasks.registerTasks({ gulp });

// 🔹 Task untuk build Tailwind
gulp.task('build:tailwind', function (cb) {
	exec(
		'npx tailwindcss -i ./src/css/tailwind/input.css -o ./src/css/tailwind/dist/output.css --minify',
		function (err, stdout, stderr) {
			console.log(stdout);
			console.error(stderr);
			cb(err);
		}
	);
});

// 🔹 Task untuk copy hasil .war ke folder deploy
const DEPLOY_PATH = process.env.DEPLOY_PATH;

gulp.task('deploy', function (cb) {
	const fs = require('fs');
	const path = require('path');

	const distDir = path.resolve(__dirname, 'dist');

	fs.readdir(distDir, (err, files) => {
		if (err) {
			console.error('Gagal membaca folder dist:', err);
			return cb(err);
		}

		const warFiles = files.filter(f => f.endsWith('.war'));
		if (warFiles.length === 0) {
			console.log('Tidak ada file .war ditemukan di dist/');
			return cb();
		}

		const fsp = fs.promises;
		Promise.all(
			warFiles.map(file => {
				const src = path.join(distDir, file);
				const dest = path.join(DEPLOY_PATH, file);
				console.log(`Menyalin ${file} ke ${DEPLOY_PATH}`);
				return fsp.copyFile(src, dest);
			})
		)
			.then(() => {
				console.log('>>> Semua file .war berhasil disalin ke folder deploy');
				cb();
			})
			.catch(cb);
	});
});

// 🔹 Override task build supaya urut: Tailwind → Build Liferay → Copy .war
const originalBuild = gulp.task('build');
gulp.task('build', gulp.series('build:tailwind', originalBuild, 'deploy'));
