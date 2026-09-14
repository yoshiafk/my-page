<%@ include file="../../init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>

<%
	String target = (String) renderRequest.getAttribute("target");
	String channel = !Validator.isNull((String) renderRequest.getAttribute("channel")) ? (String) renderRequest.getAttribute("channel") : "";
	String vaNumber = !Validator.isNull((String) renderRequest.getAttribute("vaNumber")) ? (String) renderRequest.getAttribute("vaNumber") : "";
%>

<%@ include file="../../includes/header.jsp" %>

<portlet:resourceURL id="getdatapaymentstatus" var="loadPaymentStatusDataURL" />
<portlet:resourceURL id="/auth/out" var="outURL" />

<div class="transaction-instructions">
    <div class="container-axa">
        <div class="transaction-instructions__grid">
            <div class="col-grid">
                <div class="bg-white-border p-20px-35px">
                    <h1 class="text-responsive-32px mb-8px">Silakan Transfer</h1>
                    
                    <div class="information-transfer">
                        <ul class="information-transfer__desc">
                            <li>
                                <p>Virtual Account</p>
                                <span><div class="skeleton skeleton-text"></div></span>
                            </li>
                            <li>
                                <p>Nomor Virtual Account</p>
                                <span class="copy-link-wrapper">
                                    <span id="v-account"><div class="skeleton skeleton-text"></div></span>
                                    <a href="javascript:void(0)" class="copy-link" onclick="copyText('v-account')">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
                                            <mask id="mask0_54_634" style="mask-type:alpha" maskUnits="userSpaceOnUse" x="0" y="0" width="24" height="24">
                                                <rect width="24" height="24" />
                                            </mask>
                                            <g mask="url(#mask0_54_634)">
                                                <path d="M9 18C8.45 18 7.97917 17.8042 7.5875 17.4125C7.19583 17.0208 7 16.55 7 16V4C7 3.45 7.19583 2.97917 7.5875 2.5875C7.97917 2.19583 8.45 2 9 2H18C18.55 2 19.0208 2.19583 19.4125 2.5875C19.8042 2.97917 20 3.45 20 4V16C20 16.55 19.8042 17.0208 19.4125 17.4125C19.0208 17.8042 18.55 18 18 18H9ZM9 16H18V4H9V16ZM5 22C4.45 22 3.97917 21.8042 3.5875 21.4125C3.19583 21.0208 3 20.55 3 20V6H5V20H16V22H5Z" />
                                            </g>
                                        </svg>
                                    </a>
                                </span>
                            </li>
                            <li>
                                <p>Total pembayaran</p>
                                <span><div class="skeleton skeleton-text"></div></span>
                            </li>
                        </ul>
                    </div>

                    <div class="status-payment-label">
                        <p>Status Pembayaran</p>
                        <span class="label-status pending">Menunggu Pembayaran</span>
                    </div>
                </div>

                <div class="p-20px-35px">
                    <h1 class="text-responsive-32px mb-8px">Instruksi Pembayaran</h1>
                </div>
                
                <% if (channel.equalsIgnoreCase("bca")) { %>
	                <div class="accordion" id="accordionTransactionInstructions">
	                    <div class="accordion-item">
	                        <div class="accordion-header">
	                            <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
	                                Melalui ATM BCA
	                                <i class="fas fa-chevron-down position-absolute right-32px mt-4px text-13px"></i>
	                            </button>
	                        </div>
	                        <div id="collapseOne" class="accordion-collapse collapse show" data-bs-parent="#accordionTransactionInstructions">
	                            <div class="accordion-body">
	                                <ol class="order-list-decimal">
	                                    <li>Masukkan kartu ATM BCA & PIN</li>
	                                    <li>Pilih menu Transaksi Lainnya > Transfer > ke Rekening BCA Virtual Account</li>
	                                    <li>Masukkan kode pembayaran virtual account : <%= vaNumber %></li>
	                                    <li>Di halaman konfirmasi, pastikan detail pembayaran sudah sesuai, seperti nomor VA, nama, perusahaan/produk, dan total tagihan</li>
	                                    <li>Ikuti instruksi untuk menyelesaikan transaksi</li>
	                                    <li>Simpan struk transaksi sebagai bukti pembayaran</li>
	                                </ol>
	                            </div>
	                        </div>
	                    </div>
	
	                    <div class="accordion-item">
	                        <div class="accordion-header">
	                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
	                                Melalui m-BCA (BCA Mobile)                            
	                                <i class="fas fa-chevron-down position-absolute right-32px mt-4px text-13px"></i>
	                            </button>
	                        </div>
	                        <div id="collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionTransactionInstructions">
	                            <div class="accordion-body">
	                                <ol class="order-list-decimal">
	                                    <li>Lakukan log in pada aplikasi BCA Mobile</li>
	                                    <li>Pilih menu m-BCA, kemudian masukkan kode akses m-BCA</li>
	                                    <li>Pilih m-Transfer > BCA Virtual Account</li>
	                                    <li>Pilih dari daftar transfer, atau masukkan kode pembayaran virtual account : <%= vaNumber %></li>
	                                    <li>Masukkan pin m-BCA</li>
	                                    <li>Pembayaran selesai. Simpan notifikasi yang muncul sebagai bukti pembayaran</li>
	                                </ol>
	                            </div>
	                        </div>
	                    </div>
	                    
	                    <div class="accordion-item">
	                        <div class="accordion-header">
	                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
	                                Melalui Internet Banking BCA                            
	                                <i class="fas fa-chevron-down position-absolute right-32px mt-4px text-13px"></i>
	                            </button>
	                        </div>
	                        <div id="collapseThree" class="accordion-collapse collapse" data-bs-parent="#accordionTransactionInstructions">
	                            <div class="accordion-body">
	                                <ol class="order-list-decimal">
	                                    <li>Login ke alamat Internet Banking BCA <a href="https://klikbca.com" target="_blank">(https://klikbca.com)</a></li>
	                                    <li>Pilih menu Pembayaran Tagihan > Pembayaran > BCA Virtual Account</li>
	                                    <li>Pada kolom kode bayar, masukkan kode pembayaran virtual account : <%= vaNumber %></li>
	                                    <li>Di halaman konfirmasi, pastikan detail pembayaran sudah sesuai, seperti nomor BCA Virtual Account, nama pelanggan dan jumlah pembayaran</li>
	                                    <li>Masukkan password dan mToken</li>
	                                    <li>Cetak atau simpan struk pembayaran BCA Virtual Account sebagai bukti pembayaran</li>
	                                </ol>
	                            </div>
	                        </div>
	                    </div>
	                    
	                    <div class="accordion-item">
	                        <div class="accordion-header">
	                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
	                                Melalui Kantor BCA                            
	                                <i class="fas fa-chevron-down position-absolute right-32px mt-4px text-13px"></i>
	                            </button>
	                        </div>
	                        <div id="collapseFour" class="accordion-collapse collapse" data-bs-parent="#accordionTransactionInstructions">
	                            <div class="accordion-body">
	                                <ol class="order-list-decimal">
	                                    <li>Ambil nomor antrian transaksi teller dan isi slip setoran</li>
	                                    <li>Masukkan nomor virtual account &ldquo;<%= vaNumber %>&rdquo; sebagai tujuan pembayaran</li>
	                                    <li>Serahkan slip dan jumlah setoran kepada teller BCA</li>
	                                    <li>Teller BCA akan melakukan validasi transaksi</li>
	                                    <li>Simpan slip sestoran hasil validasi sebagai bukti pembayaran</li>
	                                </ol>
	                            </div>
	                        </div>
	                    </div>
	                </div>
				<% } %>
				
				<% if (channel.equalsIgnoreCase("mandiri")) { %>
	                <div class="accordion" id="accordionTransactionInstructions">
	                    <div class="accordion-item">
	                        <div class="accordion-header">
	                            <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
	                                Melalui Livin&rsquo; by Mandiri
	                                <i class="fas fa-chevron-down position-absolute right-32px mt-4px text-13px"></i>
	                            </button>
	                        </div>
	                        <div id="collapseOne" class="accordion-collapse collapse show" data-bs-parent="#accordionTransactionInstructions">
	                            <div class="accordion-body">
	                                <ol class="order-list-decimal">
	                                    <li>Login ke aplikasi Livin&rsquo;</li>
	                                    <li>Pilih menu &ldquo;Bayar&rdquo;</li>
	                                    <li>Masukkan nomor VA &ldquo;<%= vaNumber %>&rdquo; secara keseluruhan, kemudian tekan Lanjutkan</li>
	                                    <li>Pastikan detail pembayaran sudah sesuai dan nominal pembayaran benar</li>
	                                    <li>Pilih rekening sumber</li>
	                                    <li>Pilih Lanjut Bayar kemudian masukkan PIN dan konfirmasi</li>
	                                    <li>Transaksi selesai. Simpan resi sebagai bukti transaksi</li>
	                                </ol>
	                            </div>
	                        </div>
	                    </div>
	
	                    <div class="accordion-item">
	                        <div class="accordion-header">
	                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
	                                Melalui ATM Mandiri                            
	                                <i class="fas fa-chevron-down position-absolute right-32px mt-4px text-13px"></i>
	                            </button>
	                        </div>
	                        <div id="collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionTransactionInstructions">
	                            <div class="accordion-body">
	                                <ol class="order-list-decimal">
	                                    <li>Masukkan kartu ATM Mandiri, lalu pilih bahasa</li>
	                                    <li>Masukkan PIN ATM</li>
	                                    <li>Pilih menu &ldquo;Bayar/Beli&rdquo;</li>
	                                    <li>Pilih menu &ldquo;Multipayment&rdquo;</li>
	                                    <li>Masukkan kode perusahaan/institusi &ldquo;89705&rdquo;, kemudian tekan Benar</li>
	                                    <li>Masukkan nomor VA &ldquo;<%= vaNumber %>&rdquo; secara keseluruhan, lalu masukkan nominal, kemudian tekan Lanjutkan</li>
	                                    <li>Pastikan detail pembayaran sudah sesuai, seperti nomor VA, jumlah pembayaran dan detail lainnya</li>
	                                    <li>Konfirmasi pembayaran dengan pilih &ldquo;Ya&rdquo;</li>
	                                    <li>Transaksi selesai. Simpan resi sebagai bukti transaksi</li>
	                                </ol>
	                            </div>
	                        </div>
	                    </div>
	                    
	                    <div class="accordion-item">
	                        <div class="accordion-header">
	                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
	                                Melalui ATM Bank Lain                            
	                                <i class="fas fa-chevron-down position-absolute right-32px mt-4px text-13px"></i>
	                            </button>
	                        </div>
	                        <div id="collapseThree" class="accordion-collapse collapse" data-bs-parent="#accordionTransactionInstructions">
	                            <div class="accordion-body">
	                                <ol class="order-list-decimal">
	                                    <li>Masukkan PIN</li>
	                                    <li>Pilih menu &ldquo;Transfer&rdquo;</li>
	                                    <li>Pilih &ldquo;Ke Rek Bank Lain&rdquo;</li>
	                                    <li>Masukkan kode Bank Mandiri 008 dan kode bayar &ldquo;<%= vaNumber %>&rdquo; sebagai rekening tujuan, kemudian tekan &ldquo;Benar&rdquo;</li>
	                                    <li>Masukkan jumlah pembayaran dan pilih &ldquo;Benar&rdquo;</li>
	                                    <li>Layar konfirmasi transfer akan muncul, berisi nomor rekening tujuan, nama, dan jumlah yang dibayar. Jika sudah benar, tekan &ldquo;Benar&rdquo;</li>
	                                    <li>Transaksi selesai</li>
	                                </ol>
	                            </div>
	                        </div>
	                    </div>
	                </div>
				<% } %>
            </div>
            <div class="col-grid">
                <div class="bg-white-border">
                    <div class="summary__payment">
                        <div class="summary_payment-heading border-bottom">
                            <h1 class="text-responsive-32px">Rincian</h1>
                            <span><div class="skeleton skeleton-text"></div></span>
                            <ul class="total-details">
                                <li>Total Pembayaran</li>
                                <li><div class="skeleton skeleton-text-right"></div></li>
                            </ul>
                        </div>

                        <div class="summary_payment-body border-bottom">
                            <ul class="summary-pay__policy">
                                <li>
                                    <p>Nama</p>
                                    <span><div class="skeleton skeleton-text"></div></span>
                                </li>
                                <li>
                                    <p>Email</p>
                                    <span><div class="skeleton skeleton-text"></div></span>
                                </li>
                                <li>
                                    <p>No Kontak</p>
                                    <span><div class="skeleton skeleton-text"></div></span>
                                </li>
                            </ul>
                        </div>

                        <div class="summary-button pb-20px px-35px mt-4">
                            <a href="<%= target %>" class="btn btn--dark-blue width-full display-block align-text-center p-15px-15px-15px-18px link-product">
                                <span class="position-relative order-10">Kembali <i class="fas fa-arrow-right fa-fw ml-5px"></i></span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<liferay-util:html-bottom outputKey="htmlbottom">
	<script>
		window.loadPaymentStatusDataURL = "<%= loadPaymentStatusDataURL %>";
		window.outURL = "<%= outURL %>";
	</script>
	<script src="<%= request.getContextPath() %>/payment/instruction/js/main.js" type="text/javascript"></script>
	<script src="<%= request.getContextPath() %>/includes/js/main.js" type="text/javascript"></script>
</liferay-util:html-bottom>