<!-- BREADCRUMB START -->
<section class="breadcrumb-section">
    <div class="container-fluid">
        <div class="row">
            <div class="item <%= stepNumber >= 1 ? "active" : "" %> <%= stepNumber == 1 ? "col-4" : "col" %> <%= stepNumber == 1 ? "last" : "" %> <%= (stepHalf) ? "half" : "" %>">
                <span class="number">1</span>
                <span class="text">Penawaran Kami</span>
            </div>

            <div class="item <%= stepNumber >= 2 ? "active" : "" %> <%= stepNumber == 2 ? "col-4" : "col" %> <%= stepNumber == 2 ? "last" : "" %> <%= (stepHalf) ? "half" : "" %>">
                <span class="number">2</span>
                <span class="text">Info Pribadi</span>
            </div>

            <div class="item <%= stepNumber >= 3 ? "active" : "" %> <%= stepNumber == 3 ? "col-4" : "col" %> <%= stepNumber == 3 ? "last" : "" %> <%= (stepHalf) ? "half" : "" %>">
                <span class="number">3</span>
                <span class="text">Info Hewan Peliharaan</span>
            </div>

            <div class="item <%= stepNumber >= 4 ? "active" : "" %> <%= stepNumber == 4 ? "col-4" : "col" %> <%= stepNumber == 4 ? "last" : "" %> <%= (stepHalf) ? "half" : "" %>">
                <span class="number">4</span>
                <span class="text">Persetujuan</span>
            </div>

            <div class="item <%= stepNumber >= 5 ? "active" : "" %> <%= stepNumber == 5 ? "col-4" : "col" %> <%= stepNumber == 5 ? "last" : "" %> <%= (stepHalf) ? "half" : "" %>">
                <span class="number">5</span>
                <span class="text">Pembayaran</span>
            </div>
        </div>
    </div>
</section>
<!-- BREADCRUMB END -->