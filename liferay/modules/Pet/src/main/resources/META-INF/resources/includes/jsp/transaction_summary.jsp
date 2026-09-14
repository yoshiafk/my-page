<div class="sidebar-detail-agent-wrap">
<!--   <div class="row fz-12 text-uppercase pt-2 pb-2 sidebar-detail-agent"> -->
<!--     <div class="col-xl-3 col-lg-3 col-md-3 col-3"> -->
<!--       <span class="semi-bold"><i class="fal fa-user fa-fw"></i> Agent</span> -->
<!--     </div> -->
<!--     <div class="col-xl-9 col-lg-9 col-md-9 col-9 text-right"> -->
<!--       <span class="semi-bold">RIFKI001 - RIFKI</span> -->
<!--     </div> -->
<!--   </div> -->
</div>

<div class="sidebar-plan text-center mt-4 mb-4">
  <div class="form-group row justify-content-center">
    <div class="col-xl-7 col-lg-9 col-md-12 col-7">
      <select id="sidebar-plan" class="form-control select-sidebar semi-bold selectize w-100" name="SidebarPlan" required>
        <option value="">Pilih Plan</option>
        <% if(petPlans != null) { %> <%for(PetPlan _plan : petPlans) { %>
        <option data-custom="<%= _plan.getCustomPlan() %>" value="<%= _plan.getPetPlanId() %>"><%= _plan.getName() %></option>
        <% } %> <% } %>
      </select>
    </div>
  </div>
</div>

<div class="sidebar-detail-eh mb-2 c-black-0 d-none">
  <div class="loading-box"></div>
</div>

<div class="sidebar-total sidebar-pad mb-1">
  <div class="sidebar-total-pad">
    <div class="row item Premium d-none">
      <div class="col-xl-7 col-lg-6 col-md-12 col-7">
        <span>Subtotal</span>
      </div>
      <div class="col-xl-5 col-lg-6 col-md-12 col-5">
        <div class="idr">
          <span class="amount">1000000</span>
        </div>
      </div>
    </div>

    <div class="row item PolicyCost d-none">
      <div class="col-xl-7 col-lg-6 col-md-12 col-7">
        <span>Biaya Polis</span>
      </div>
      <div class="col-xl-5 col-lg-6 col-md-12 col-5">
        <div class="idr">
          <span class="amount">1000000</span>
        </div>
      </div>
    </div>

    <div class="row item StampDuty d-none">
      <div class="col-xl-7 col-lg-6 col-md-12 col-7">
        <span>Biaya Materai</span>
      </div>
      <div class="col-xl-5 col-lg-6 col-md-12 col-5">
        <div class="idr">
          <span class="amount">500000</span>
        </div>
      </div>
    </div>

    <div class="promo d-none">
      <div class="row Discount d-none">
        <div class="col-xl-7 col-lg-6 col-md-12 col-7">
          <span>Kode Promo</span>
        </div>
        <div class="col-xl-5 col-lg-6 col-md-12 col-5">
          <div class="idr">
            <span class="amount">-</span>
          </div>
        </div>
      </div>
      <div class="input-group">
        <input id="promocode" type="text" class="form-control semi-bold" placeholder="Masukkan Kode Promo" value="" />
        <div class="input-group-append">
          <button type="button" class="btn btn-blue-600 btn-promocode"><i class="fas fa-redo"></i></button>
        </div>
      </div>
      <span class="info light fz-11"><i></i></span>
    </div>
  </div>
</div>

<div class="grand-total semi-bold NetPremium d-none">
  <div class="row">
    <div class="col-lg-6 col-md-12 col-6">
      <span>TOTAL BIAYA</span>
    </div>
    <div class="col-lg-6 col-md-12 col-6 text">Rp <span class="amount">100000</span></div>
  </div>

  <div class="row nett-wrap d-none">
    <div class="col-lg-6 col-md-12 col-6">
      <span>NETT PREMI</span>
    </div>
    <div class="col-lg-6 col-md-12 col-6 text">Rp <span class="nett-amount">-</span></div>
  </div>
</div>
