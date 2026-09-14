<%@ include file="/init.jsp"%>

<liferay-util:body-bottom outputKey="asmikPaBodyBottom">
  <portlet:resourceURL id="/data/asmik" var="loadAsmikData" cacheability="FULL" />
  <script type="text/javascript">
    var asmikEIPURL = "<%=loadAsmikData%>";
  </script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/jquery-ui.min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/pa.js"></script>
</liferay-util:body-bottom>

<portlet:renderURL var="mikroLandingPage">
  <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<section class="hero mb-0">
  <div class="container">
    <h1>Kalkulator PA Plus</h1>
  </div>
</section>

<nav aria-label="breadcrumb" class="micro-breadcrumb mb-5">
  <div class="container">
    <ol class="breadcrumb mt-0 px-0">
      <li class="breadcrumb-item">
        <a href="<%=mikroLandingPage%>">
          <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-chevron-left"><polyline points="15 18 9 12 15 6"></polyline></svg> Kembali</a
        >
      </li>
    </ol>
  </div>
</nav>

<div class="container">
  <!--   <div class="page-header">
    <h1>KALKULATOR PERSONAL ACCIDENT PLUS</h1>
  </div> -->

  <form role="form">
    <div class="row mb-3">
      <label class="col-sm-3 mb-0 control-label">Nilai Pertanggungan (Limit Kredit) </label>
      <div class="col-sm-3">
        <div class="input-group">
          <input type="text" class="form-control" autocomplete="off" id="idLimitKredit" />
          <input type="text" hidden="hidden" id="idLimitTmp" />
        </div>
        <label class="text-danger" id="errorLimit" hidden="hidden">Nilai limit max adalah Rp.500.000.000</label>
      </div>
      <label class="col-sm-3 mb-0 control-label">Usia Tertanggung Pada Akhir Asuransi (tahun)</label>
      <div class="col-sm-3">
        <div class="input-group">
          <input type="text" id="AgeLast" class="form-control" readonly="readonly" placeholder="0" />
          <input type="text" hidden="hidden" id="ageLastTmp" />
        </div>
      </div>
    </div>

    <div class="row mb-3">
      <label class="col-sm-3 mb-0 control-label">Tanggal Lahir Tertanggung </label>
      <div class="col-sm-3">
        <div class="input-daterange">
          <div class="wrap-calendar">
            <input type="text" class="form-control datepicker required" name="BirthDate" id="BirthDate" autocomplete="off" />
            <div class="wrap-icon-cal"><i class="fa fa-calendar"></i></div>
          </div>
        </div>
      </div>
      <label class="col-sm-3 mb-0 control-label">AXA Insurance Rate (&#8240;)</label>
      <div class="col-sm-3">
        <div class="input-group">
          <input type="text" id="MagiRate" class="form-control" readonly="readonly" placeholder="0" />
          <input type="text" hidden="hidden" id="idMagiTmp" />
        </div>
      </div>
    </div>

    <div class="row mb-3">
      <label class="col-sm-3 agent-cy-fs-18 control-label mandatory">Jangka Waktu Pertanggungan PA Plus (bulan) </label>
      <div class="col-sm-3">
        <div class="form-select">
          <div class="wrap-select">
            <select name="Periode" id="Periode" class="agent-cy-fs-16 form-control select-box required nationality-select">
              <option value="" selected>-- Pilih --</option>
            </select>
            <div class="icon">
              <i class="fa fa-angle-down"></i>
            </div>
          </div>
        </div>
      </div>
      <label class="col-sm-3 mb-0 control-label">AMFS Rate (&#8240;)</label>
      <div class="col-sm-3">
        <div class="input-group">
          <input type="text" id="AMFSRate" class="form-control" readonly="readonly" placeholder="0" />
          <input type="text" hidden="hidden" id="idAMFSTmp" />
        </div>
      </div>
    </div>

    <div class="row mb-3">
      <label class="col-sm-3 mb-0 control-label">Tanggal Mulai Asuransi </label>
      <div class="col-sm-3">
        <div class="input-daterange">
          <div class="wrap-calendar">
            <input type="text" class="form-control datepicker required" name="StartDate" id="StartDate" autocomplete="off" />
            <div class="wrap-icon-cal"><i class="fa fa-calendar"></i></div>
          </div>
        </div>
      </div>
      <label class="col-sm-3 mb-0 control-label">
        <mark><b>Total Rate (&#8240;)</b></mark></label
      >
      <div class="col-sm-3">
        <div class="input-group">
          <input type="text" id="TotalRate" class="form-control" readonly="readonly" placeholder="0" />
          <input type="text" hidden="hidden" id="idTotalTmp" />
        </div>
      </div>
    </div>

    <div class="row mb-3">
      <label class="col-sm-3 mb-0 control-label">Tanggal Akhir Asuransi </label>
      <div class="col-sm-3">
        <div class="input-daterange">
          <div class="wrap-calendar">
            <input type="text" class="form-control required" name="EndDate" id="EndDate" autocomplete="off" disabled="disabled" />
            <div class="wrap-icon-cal"><i class="fa fa-calendar"></i></div>
          </div>
        </div>
      </div>
      <label class="col-sm-3 mb-0 control-label">
        <mark><b>PREMI TOTAL*</b></mark>
        <br />
        <span style="color: red">Premi belum termasuk biaya polis dan materai</span>
      </label>
      <div class="col-sm-3">
        <div class="input-group">
          <input type="text" id="PremiTotal" class="form-control" readonly="readonly" value="0" />
        </div>
      </div>
    </div>

    <div class="row mb-3">
      <label class="col-sm-3 mb-0 control-label">Usia Tertanggung Pada Mulai Asuransi (tahun) </label>
      <div class="col-sm-3">
        <div class="input-group">
          <input type="text" class="form-control" autocomplete="off" id="AgeStart" readonly="readonly" placeholder="0" />
          <input type="text" hidden="hidden" id="ageStartTmp" />
        </div>
        <label class="text-danger" id="errorAgeMin" hidden="hidden">Usia pertanggungan saat mulai asuransi min 18 tahun</label>
        <label class="text-danger" id="errorAgeMax" hidden="hidden">Usia pertanggungan saat mulai asuransi max 51 tahun 365 hari</label>
      </div>
    </div>
  </form>
</div>
