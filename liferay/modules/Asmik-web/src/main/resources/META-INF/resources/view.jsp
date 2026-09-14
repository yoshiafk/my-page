<%@ include file="/init.jsp" %>

<portlet:renderURL var="asmikMV">
  <portlet:param name="mvcPath" value="/mv.jsp"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="asmikPA">
  <portlet:param name="mvcPath" value="/pa.jsp"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="asmikFIRE">
  <portlet:param name="mvcPath" value="/fire.jsp"></portlet:param>
</portlet:renderURL>

<section class="hero">
  <div class="container">
    <h1>Kalkulator Mikro</h1>
  </div>
</section>

<div class="container-fluid pt-5 pb-5 text-center">
  <div class="row text-center mb-5">
    <div class="col-md-12">
      <a href="<%= asmikMV %>" class="sz-12 d-flex justify-content-center align-items-center mr-auto ml-auto btn btn-axa-orange opt-product mb-2 sz-15">Kalkulator MV TLO</a>
    </div>

    <div class="col-md-12">
      <a href="<%= asmikPA %>" class="sz-12 d-flex justify-content-center align-items-center mr-auto ml-auto btn btn-axa-orange opt-product mb-2 sz-15 mt-2">Kalkulator PA Plus</a>
    </div>

    <div class="col-md-12">
      <a href="<%= asmikFIRE %>" class="sz-12 d-flex justify-content-center align-items-center mr-auto ml-auto btn btn-axa-orange opt-product mb-2 sz-15 mt-2">Kalkulator Fire</a>
    </div>
  </div>
</div>
