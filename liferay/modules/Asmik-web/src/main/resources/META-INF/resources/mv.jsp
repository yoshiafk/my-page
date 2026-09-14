<%@ include file="/init.jsp"%>

<liferay-util:body-bottom outputKey="asmikMvBodyBottom">
  <portlet:resourceURL id="/data/asmik" var="loadAsmikData" cacheability="FULL" />
  <script type="text/javascript">
    var asmikEIPURL = "<%=loadAsmikData%>";
  </script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/jquery-ui.min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/includes/js/mv.js"></script>
</liferay-util:body-bottom>

<portlet:renderURL var="mikroLandingPage">
  <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<section class="hero mb-0">
  <div class="container">
    <h1>Kalkulator MV TLO</h1>
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
  <form role="form">
    <div class="row mb-3">
      <label class="col-sm-3 mb-0 control-label">Jenis Skema Produk</label>
      <div class="col-sm-3">
        <div class="input-group">
          <input type="text" disabled="disabled" value="MV Micro" class="form-control" />
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
      <label class="col-sm-3 mb-0 control-label">Jaminan</label>
      <div class="col-sm-3">
        <div class="input-group">
          <input type="text" value="Total Loss Only (TLO)" disabled="disabled" class="form-control" />
        </div>
      </div>
      <label class="col-sm-3 agent-cy-fs-18 control-label mandatory">Tenor</label>
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
    </div>
    <div class="row mb-3">
      <label class="col-sm-3 agent-cy-fs-18 control-label mandatory">Jenis Kendaraan</label>
      <div class="col-sm-3">
        <div class="form-select">
          <div class="wrap-select">
            <select id="JenisKendaraan" name="JenisKendaraan" class="agent-cy-fs-16 form-control select-box required nationality-select">
              <option value="" selected>-- Pilih --</option>
            </select>
            <div class="icon">
              <i class="fa fa-angle-down"></i>
            </div>
          </div>
        </div>
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
      <label class="col-sm-3 mb-0 control-label">Usia Kendaraan</label>
      <div class="col-sm-3">
        <div class="input-group">
          <input type="number" id="UsiaKendaraan" class="form-control" min="1" />
        </div>
        <label class="text-danger" id="errorAge">Ditolak</label>
        <label id="errorAgeMsg"></label>
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
      <label class="col-sm-3 mb-0 control-label">Harga Pertanggungan </label>
      <div class="col-sm-3">
        <div class="input-group">
          <input type="text" class="form-control" autocomplete="off" id="Harga" />
          <input type="text" autocomplete="off" id="HargaTmp" class="d-none" />
        </div>
        <label class="text-danger" id="errorHarga">Ditolak</label>
        <label id="errorHargaMsg"></label>
      </div>
      <label class="col-sm-3 mb-0 control-label">
        <mark><b> Tarif Premi TLO ( % )</b> </mark>
      </label>
      <div class="col-sm-3">
        <div class="input-group">
          <input type="text" id="RateTLO" class="form-control" readonly="readonly" value="0" />
          <input type="text" id="RateTLOTmp" class="d-none" />
        </div>
        <label class="text-danger" id="errorRate">Rate indikasi, hub UW AXA Insurance</label>
      </div>
    </div>
    <div class="row mb-3">
      <label class="col-sm-3 agent-cy-fs-18 control-label mandatory">Zona Berdasarkan Plat Nomor</label>
      <div class="col-sm-3">
        <div class="form-select">
          <div class="wrap-select">
            <select id="Zona" name="Zona" class="agent-cy-fs-16 form-control select-box required nationality-select">
              <option value="" selected>-- Pilih --</option>
            </select>
            <div class="icon">
              <i class="fa fa-angle-down"></i>
            </div>
          </div>
        </div>
      </div>
      <label class="col-sm-3 mb-0 control-label">
        <mark><b> Tarif Premi SRCC ( % )</b> </mark>
      </label>
      <div class="col-sm-3">
        <div class="input-group">
          <input type="text" id="RateSRCC" class="form-control" readonly="readonly" value="0" />
          <input type="text" id="RateSRCCTmp" class="d-none" />
        </div>
      </div>
    </div>
    
    
    <!-- ENHANCEMENT -->
    
    <div class="row mb-3">
      <label class="col-sm-3 agent-cy-fs-18 control-label mandatory">
      	Tambahan Benefit SRCC
      	<br />
        <span style="color: #F7374F">Huru-Hara dan Kerusuhan (<i>Strike, Riot, and Civil Commotion</i>)</span>
      </label>
      <div class="col-sm-3">
        <div class="form-select">
          <div class="wrap-select">
            <select id="AddBenefit" class="agent-cy-fs-16 form-control select-box required nationality-select">
              <option value="" selected>-- Pilih --</option>
              <option value="Yes">Yes</option>
              <option value="No">No</option>
            </select>
            <div class="icon">
              <i class="fa fa-angle-down"></i>
            </div>
          </div>
        </div>
      </div>
      
      <label class="col-sm-3 mb-0 control-label">
        <mark><b> Tarif Premi SRCC + TS ( % )</b> </mark>
      </label>
      <div class="col-sm-3">
        <div class="input-group">
          <input type="text" id="RateSRCC_plusTS" class="form-control" readonly="readonly" value="0" />
          <input type="text" id="RateSRCCTmp_plusTS" class="d-none" />
        </div>
      </div>
      
      
    </div>
    
    
    <div class="row mb-3">
      <label class="col-sm-3 agent-cy-fs-18 control-label mandatory">
      	Tambahan Benefit SRCC + TS
      	<br />
        <span style="color: #F7374F">Huru-hara, Kerusuhan, Terorisme, dan Sabotase (<i>Strike, Riot, Civil Commotion, Terrorism, and Sabotage</i>)</span>
      </label>
      <div class="col-sm-3">
        <div class="form-select">
          <div class="wrap-select">
            <select id="AddBenefit_SRCC_plusTS" class="agent-cy-fs-16 form-control select-box required nationality-select" disabled>
              <option value="" selected>-- Pilih --</option>
              <option value="Yes">Yes</option>
              <option value="No">No</option>
            </select>
            <div class="icon">
              <i class="fa fa-angle-down"></i>
            </div>
          </div>
        </div>
      </div>
      
      <label class="col-sm-3 mb-0 control-label">
        <mark><b> Tarif Premi Flood ( % )</b> </mark>
      </label>
      <div class="col-sm-3">
        <div class="input-group">
          <input type="text" id="RateFlood" class="form-control" readonly="readonly" value="0" />
          <input type="text" id="RateFloodTmp" class="d-none" />
        </div>
      </div>
      
    </div>
    
    
    <div class="row mb-3">
      <label class="col-sm-3 agent-cy-fs-18 control-label mandatory">
      	Tambahan Benefit Flood
      	<br />
        <span style="color: #F7374F">Angin Topan, Badai, Hujan Es, Banjir dan/atau Tanah Longsor (<i>Typhoon, Storm, Hail, Flood and/or Landslide</i>)</span>
      </label>
      <div class="col-sm-3">
        <div class="form-select">
          <div class="wrap-select">
            <select id="AddBenefit_Flood" class="agent-cy-fs-16 form-control select-box required nationality-select">
              <option value="" selected>-- Pilih --</option>
              <option value="Yes">Yes</option>
              <option value="No">No</option>
            </select>
            <div class="icon">
              <i class="fa fa-angle-down"></i>
            </div>
          </div>
        </div>
      </div>
      
      <label class="col-sm-3 mb-0 control-label">
        <mark><b> Tarif Premi EQ ( % )</b> </mark>
      </label>
      <div class="col-sm-3">
        <div class="input-group">
          <input type="text" id="RateEQ" class="form-control" readonly="readonly" value="0" />
          <input type="text" id="RateEQTmp" class="d-none" />
        </div>
      </div>
        
      
    </div>
    
    
    <div class="row mb-3">
      <label class="col-sm-3 agent-cy-fs-18 control-label mandatory">
      	Tambahan Benefit EQ
      	<br />
        <span style="color: #F7374F">Gempa Bumi, Tsunami dan/atau letusan Gunung Berapi (<i>Earthquake, Tsunami and/or Volcanic Eruption</i>)</span>
      </label>
      <div class="col-sm-3">
        <div class="form-select">
          <div class="wrap-select">
            <select id="AddBenefit_EQ" class="agent-cy-fs-16 form-control select-box required nationality-select">
              <option value="" selected>-- Pilih --</option>
              <option value="Yes">Yes</option>
              <option value="No">No</option>
            </select>
            <div class="icon">
              <i class="fa fa-angle-down"></i>
            </div>
          </div>
        </div>
      </div>
      
      <label class="col-sm-3 mb-0 control-label">
        <mark><b>PREMI*</b></mark>
        <br />
        <span style="color: #F7374F">Premi belum termasuk biaya polis dan materai</span>
      </label>
      <div class="col-sm-3">
        <div class="input-group">
          <input type="text" id="idPremi" class="form-control" readonly="readonly" value="0" />
        </div>
      </div>
      
      
    </div>
    
    
    
  </form>
</div>
