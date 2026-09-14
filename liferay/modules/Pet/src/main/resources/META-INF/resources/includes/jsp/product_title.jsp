<%@ include file="../../init.jsp" %>
<% ProductConfiguration productConfiguration = ProductConfigurationLocalServiceUtil.getConfigByCode("PET"); %>

<% String productName = !Validator.isNull(productConfiguration) ? productConfiguration.getProductName() : ""; %>
<% String ojkName = !Validator.isNull(productConfiguration) ? productConfiguration.getOjkName() : ""; %>
<section class="hero">
    <div class="container">
        <h1><%= productName %></h1>
        <h2 class="font-italic fz-9">*Terdaftar di OJK dengan nama <%= ojkName %></h2>
    </div>
</section>