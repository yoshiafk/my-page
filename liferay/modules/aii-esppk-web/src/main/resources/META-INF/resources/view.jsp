<%@ include file="/init.jsp" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />
<div id="esppk-form" class="container-axa">
  <form id="formEsppk" onsubmit="return false;">

    <!-- DATA PRIBADI -->
    <h3>I. DATA PRIBADI</h3>

    <div class="grid grid-cols-2 gap-4">
      <label for="namaLengkap">Nama Lengkap</label>
      <input type="text" id="namaLengkap" />
    </div>

    <div class="grid grid-cols-2 gap-4">
      <label for="email">Email</label>
      <input type="email" id="email" />
    </div>

    <div class="grid grid-cols-2 gap-4">
      <label for="noHp">No HP</label>
      <input type="text" id="noHp" />
    </div>

    <!-- DATA PERTANGGUNGAN -->
    <h3>II. DATA PERTANGGUNGAN</h3>

    <div class="grid grid-cols-2 gap-4">
      <label for="noPolis">No Polis</label>
      <input type="text" id="noPolis" />
    </div>

    <div class="grid grid-cols-2 gap-4">
      <label for="tglMulai">Tanggal Mulai</label>
      <input type="date" id="tglMulai" />
    </div>

    <!-- DISCLAIMER -->
    <h3>III. DISCLAIMER</h3>

    <div>
      <button type="button" data-idx="1">
        Disclaimer 1 <span>+</span>
      </button>
      <div>Lorem ipsum dolor sit amet.</div>
      <label>
        <input type="checkbox" id="d1" /> Saya setuju
      </label>
    </div>

    <div>
      <button type="button" data-idx="2">
        Disclaimer 2 <span>+</span>
      </button>
      <div>Lorem ipsum dolor sit amet.</div>
      <label>
        <input type="checkbox" id="d2" /> Saya setuju
      </label>
    </div>

    <div>
      <button type="button" data-idx="3">
        Disclaimer 3 <span>+</span>
      </button>
      <div>Lorem ipsum dolor sit amet.</div>
      <label>
        <input type="checkbox" id="d3" /> Saya setuju
      </label>
    </div>

    <!-- BUTTON -->
    <div>
      <button id="submitBtn">Kirim</button>
    </div>

    <div id="noticeArea"></div>

  </form>

</div>


<script>
function showNotice(text, error) {
  var n = document.getElementById('noticeArea');
  n.innerText = text;
  n.style.color = error ? 'red' : 'green';
  setTimeout(function(){ n.innerText=''; },3500);
}

document.querySelectorAll('.accordion-btn').forEach(function(b){
  b.addEventListener('click', function(){
    var content = b.nextElementSibling;
    var span = b.querySelector('span');
    if (content.style.display === 'none') { content.style.display = 'block'; span.textContent='−'; }
    else { content.style.display = 'none'; span.textContent='+'; }
  });
});

document.getElementById('submitBtn').addEventListener('click', function() {
  var nama = document.getElementById('namaLengkap').value.trim();
  var email = document.getElementById('email').value.trim();
  var noHp = document.getElementById('noHp').value.trim();
  var d1 = document.getElementById('d1').checked;
  var d2 = document.getElementById('d2').checked;
  var d3 = document.getElementById('d3').checked;
  if (!nama || !email || !noHp) { showNotice('Mohon isi field wajib.', true); return; }
  if (!d1 || !d2 || !d3) { showNotice('Harap menyetujui semua disclaimer.', true); return; }

  var form = new FormData();
  form.append('namaLengkap', nama);
  form.append('email', email);
  form.append('noHp', noHp);
  form.append('noPolis', document.getElementById('noPolis').value);
  form.append('tglMulai', document.getElementById('tglMulai').value);

  var resourceURL = '<portlet:resourceURL id="submit" />';
  fetch(resourceURL, { method: 'POST', body: form, credentials: 'same-origin' })
    .then(res => res.json())
    .then(json => {
      if (json.status === 'ok') { showNotice('Pengiriman berhasil.', false); document.getElementById('formEsppk').reset(); }
      else { showNotice('Gagal: ' + (json.message || 'Unknown'), true); }
    }).catch(function(){ showNotice('Terjadi kesalahan.', true); });
});
</script>
