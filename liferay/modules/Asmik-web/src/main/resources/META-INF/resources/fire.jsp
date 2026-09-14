<%@ include file="/init.jsp"%>

<liferay-util:body-bottom outputKey="asmikFireBodyBottom">
  <portlet:resourceURL id="/data/asmik" var="loadAsmikData" cacheability="FULL" />
  <script type="text/javascript">
    var asmikEIPURL = "<%=loadAsmikData%>";
  </script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/jquery-ui.min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/fire.js"></script>
</liferay-util:body-bottom>

<portlet:renderURL var="mikroLandingPage">
  <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="mikroLandingPage">
  <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<section class="hero mb-0">
  <div class="container">
    <h1>Kalkulator Fire</h1>
  </div>
</section>

<nav aria-label="breadcrumb" class="micro-breadcrumb mb-5">
<div class="container">
  <ol class="breadcrumb mt-0 px-0">
    <li class="breadcrumb-item"><a href="<%=mikroLandingPage%>"> <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-chevron-left"><polyline points="15 18 9 12 15 6"></polyline></svg> Kembali</a></li>
  </ol>
</div>
</nav>

<div class="container">
  <!-- <div class="page-header">
    <h1>Kalkulator FIRE MICRO</h1>
  </div> -->

  <form role="form">
    <div class="row mb-3">
      <label class="col-sm-3 mb-0 control-label">Jenis Pertanggungan </label>
      <div class="col-sm-3">
        <div class="form-select">
          <div class="wrap-select">
            <select id="Benefit" name="Benefit" class="agent-cy-fs-16 form-control select-box required">
              <option value="">-- Pilih --</option>
              <!-- <option value="Flexas">FLEXAS</option>
              <option value="FlexasRsmdcc">FLEXAS + RSMDCC</option>
              
              enhancement
              <option value="FlexasFtswd">FLEXAS + FTSWD</option>
              <option value="FlexasRsmdccFtswd">FLEXAS + RSMDCC + FTSWD</option> -->
              
              
            </select>
            <div class="icon">
              <i class="fa fa-angle-down"></i>
            </div>
          </div>
        </div>
      </div>

      <label class="col-sm-3 mb-0 control-label">Tanggal Pengajuan Penutupan Asuransi </label>
      <div class="col-sm-3">
        <div class="input-daterange">
          <div class="wrap-calendar">
            <input type="text" class="form-control datepicker required" name="CloseDate" id="CloseDate" autocomplete="off" />
            <div class="wrap-icon-cal"><i class="fa fa-calendar"></i></div>
          </div>
        </div>
      </div>
      
    </div>

    <div class="row mb-3">
      <label class="col-sm-3 mb-0 control-label">Construction Class </label>
      <div class="col-sm-3">
        <div class="form-select">
          <div class="wrap-select">
            <select id="KelasKonstruksi" name="KelasKonstruksi" class="agent-cy-fs-16 form-control select-box required">
              <option value="" selected>-- Pilih --</option>
            </select>
            <div class="icon">
              <i class="fa fa-angle-down"></i>
            </div>
          </div>
        </div>
        <label id="idDeskripsiKelas"></label>
      </div>

      <label class="col-sm-3 mb-0 control-label">Tanggal Mulai Asuransi </label>
      <div class="col-sm-3">
        <div class="input-daterange">
          <div class="wrap-calendar">
            <input type="text" class="form-control datepicker required" name="StartDate" id="StartDate" autocomplete="off" />
            <div class="wrap-icon-cal"><i class="fa fa-calendar"></i></div>
          </div>
        </div>
      </div>
      
    </div>

    <div class="row mb-3">
      <label class="col-sm-3 mb-0 control-label">Kegunaan Objek Bangunan (Okupansi) </label>
      <div class="col-sm-3">
        <div class="form-select">
          <div class="wrap-select">
            <select id="Pertanggungan" name="Pertanggungan" class="agent-cy-fs-16 form-control select-box required">
              <option value="" selected>-- Pilih --</option>
            </select>
            <div class="icon">
              <i class="fa fa-angle-down"></i>
            </div>
          </div>
        </div>
      </div>

            <label class="col-sm-3 mb-0 control-label">Tanggal Akhir Asuransi </label>
      <div class="col-sm-3">
        <div class="input-daterange">
          <div class="wrap-calendar">
            <input type="text" class="form-control required" name="EndDate" id="EndDate" autocomplete="off" disabled="disabled" />
            <div class="wrap-icon-cal"><i class="fa fa-calendar"></i></div>
          </div>
        </div>
      </div>
    </div>

    <div class="row mb-3">
      <label class="col-sm-3 mb-0 control-label">Deskripsi Okupansi Obyek Pertanggungan </label>
      <div class="col-sm-3">
        <div class="input-group">
          <textarea id="idDeskripsi" disabled="disabled" class="form-control"> </textarea>
        </div>
      </div>

      <label class="col-sm-3 mb-0 control-label">Harga Pertanggungan </label>
      <div class="col-sm-3">
        <div class="input-group">
          <input type="text" class="form-control" autocomplete="off" id="idHarga" />
          <input type="text" autocomplete="off" id="idHargaTmp" class="d-none" />
        </div>
        <!-- <label class="text-danger" id="errorHarga" hidden="hidden">Harga pertanggungan harus di bawah 500 jt</label> -->
        <label class="text-danger" id="errorHarga" hidden="hidden">*Nilai pertanggungan maks 3M</label>
      </div>
    </div>

    <div class="row mb-3">
      <label class="col-sm-3 mb-0 control-label">Kode Okupansi Obyek Pertanggungan </label>
      <div class="col-sm-3">
        <div class="input-group">
          <input type="text" id="idKodeOkupansi" disabled="disabled" class="form-control" />
        </div>
      </div>

      <label class="col-sm-3 mb-0 control-label">
        <mark><b> RATE (&#8240;)</b> </mark>
      </label>
      <div class="col-sm-3">
        <div class="input-group">
          <input type="text" id="idRate" class="form-control" disabled="disabled" value="0" />
          <input type="text" id="idRateTmp" class="form-control" hidden="hidden" />
        </div>
      </div>
    </div>

    <div class="row mb-3">
      <label class="col-sm-3 mb-0 control-label">Jangka Waktu Pertanggungan (bulan) </label>
      <div class="col-sm-3">
        <div class="form-select">
          <div class="wrap-select">
            <select id="Periode" name="Periode" class="agent-cy-fs-16 form-control select-box required">
              <option value="" selected>-- Pilih --</option>
            </select>
            <div class="icon">
              <i class="fa fa-angle-down"></i>
            </div>
          </div>
        </div>
      </div>

      <label class="col-sm-3 mb-0 control-label">
        <mark><b> PREMI*</b> </mark>
        <br />
        <span style="color: red">Premi belum termasuk biaya polis dan materai</span>
      </label>

      <div class="col-sm-3">
        <div class="input-group">
          <input type="text" id="idPremi" class="form-control" readonly="readonly" value="0" />
        </div>
      </div>
    </div>
  </form>
</div>
