// // OTP JS
// let in1 = document.getElementById('otc-1')
// let in2 = document.getElementById('otc-create-pass-1')
// ins = document.querySelectorAll('input[type="number"].otp-input'),
// splitNumber = function(e) {
// 	let data = e.data || e.target.value; // Chrome doesn't get the e.data, it's always empty, fallback to value then.
// 	if (!data) return; // Shouldn't happen, just in case.
// 	if (data.length === 1) return; // Here is a normal behavior, not a paste action.

// 	popuNext(e.target, data);
// 	//for (i = 0; i < data.length; i++ ) { ins[i].value = data[i]; }
// },
// popuNext = function(el, data) {
// 	el.value = data[0]; // Apply first item to first input
// 	data = data.substring(1); // remove the first char.
// 	if (el.nextElementSibling && data.length) {
// 		// Do the same with the next element and next data
// 		popuNext(el.nextElementSibling, data);
// 	}
// };

// ins.forEach(function(input) {
// /**
//  * Control on keyup to catch what the user intent to do.
//  * I could have check for numeric key only here, but I didn't.
//  */
// input.addEventListener('keyup', function(e) {
// 	// Break if Shift, Tab, CMD, Option, Control.
// 	if (e.keyCode === 16 || e.keyCode == 9 || e.keyCode == 224 || e.keyCode == 18 || e.keyCode == 17) {
// 		return;
// 	}

// 	// On Backspace or left arrow, go to the previous field.
// 	if ((e.keyCode === 8 || e.keyCode === 37) && this.previousElementSibling && this.previousElementSibling.tagName === "INPUT") {
// 		this.previousElementSibling.select('disabled', false);
// 	} else if (e.keyCode !== 8 && this.nextElementSibling) {
// 		this.nextElementSibling.select();
// 	}
// 	// If the target is populated to quickly, value length can be > 1
// 	if (e.target.value.length > 1) {
// 		splitNumber(e);
// 	}
// });

// /**
//  * Better control on Focus
//  * - don't allow focus on other field if the first one is empty
//  * - don't allow focus on field if the previous one if empty (debatable)
//  * - get the focus on the first empty field
//  */
// input.addEventListener('focus', function(e) {
// 	// If the focus element is the first one, do nothing
// 	if (this === in1) return;
// 	if (this === in2) return;

// 	// If value of input 1 is empty, focus it.
// 	if (in1.value == '') {
// 		in1.focus();
// 	}
// 	if (in2.value == '') {
// 		in2.focus();
// 	}

// 	// If value of a previous input is empty, focus it.
// 	// To remove if you don't wanna force user respecting the fields order.
// 	if (this.previousElementSibling.value == '') {
// 		this.previousElementSibling.focus();
// 	}
// });
// });

// /**
// * Handle copy/paste of a big number.
// * It catches the value pasted on the first field and spread it into the inputs.
// */
// in1.addEventListener('input', splitNumber);

// // End OTP JS

// // Timer OTP
// let timerOn = true;

// function timer(remaining) {
// 	// var m = Math.floor(remaining / 98);
// 	// var s = remaining % 98;
// 	var m = Math.floor(remaining / 20);
// 	var s = remaining % 20;

// 	m = m < 10 ? '0' + m : m;
// 	s = s < 10 ? '0' + s : s;
// 	document.getElementById('timer').innerHTML = m + ':' + s;
// 	remaining -= 1;

// 	if (remaining >= 0 && timerOn) {
// 		$('.link-otp').addClass('disabled'); 
// 		$('.link-otp').prop("disabled", true);
// 		setTimeout(function() {
// 			$('.link-otp').removeClass('disabled'); 
// 			$('.link-otp').prop("disabled", false);
// 	  }, 1000) 
// 		setTimeout(function() {
// 			timer(remaining);
// 		}, 1000);
// 		return;
// 	}
	
// 	if (!timerOn) {
// 		// Do validate stuff here
// 		return;
// 	}

// 	// Do timeout stuff here
// 	// alert('Timeout for otp');
// }

// timer(120);
// // document.getElementById("sendOTP").addEventListener("click", function(){ 

// // });

(function () {
	const inputs = document.querySelectorAll("#otp-field input");
  
	for (let i = 0; i < inputs.length; i++) {
	  const input = inputs[i];
  
	  input.addEventListener("input", function () {
		// handling normal input
		if (input.value.length == 1 && i+1 < inputs.length) {
		  inputs[i+1].focus();
		}
  
		// if a value is pasted, put each character to each of the next input
		if (input.value.length > 1) {
		  // sanitise input
		  if (isNaN(input.value)) {
			input.value = "";
			updateInput();
			return;
		  }
  
		  // split characters to array
		  const chars = input.value.split('');
  
		  for (let pos = 0; pos < chars.length; pos++) {
			// if length exceeded the number of inputs, stop
			if (pos + i >= inputs.length) break;
  
			// paste value
			let targetInput = inputs[pos + i];
			targetInput.value = chars[pos];
		  }
  
		  // focus the input next to the last pasted character
		  let focus_index = Math.min(inputs.length - 1, i + chars.length);
		  inputs[focus_index].focus();
		}
		updateInput();
	  });
	  
	  function removeclassInput() {
		input.classList.remove('success');
	  }
  
	  input.addEventListener("keydown", function (e) {
		// backspace button
		if (e.keyCode == 8 && input.value == '' && i != 0) {
		  // shift next values towards the left
		  for (let pos = i; pos < inputs.length - 1; pos++) {
			inputs[pos].value = inputs[pos + 1].value;
		  }
  
		  // clear previous box and focus on it
		  inputs[i-1].value = '';
		  inputs[i-1].focus();
		  updateInput();
		  removeclassInput();
		  return;
		}
  
		// delete button
		if (e.keyCode == 46 && i != inputs.length - 1) {
		  // shift next values towards the left
		  for (let pos = i; pos < inputs.length - 1; pos++) {
			inputs[pos].value = inputs[pos + 1].value;
		  }
  
		  // clear the last box
		  inputs[inputs.length - 1].value = '';
		  input.select();
		  e.preventDefault();
		  updateInput();
		  return;
		}
  
		// left button
		if (e.keyCode == 37) {
		  if (i > 0) {
			e.preventDefault();
			inputs[i-1].focus();
			inputs[i-1].select();
		  }
		  return;
		}
		
		// right button
		if (e.keyCode == 39) {
		  if (i+1 < inputs.length) {
			e.preventDefault();
			inputs[i+1].focus();
			inputs[i+1].select();
		  }
		  return;
		}
	  });

	}
	
	function updateInput() {
	  let inputValue = Array.from(inputs).reduce(function (otp, input) {
		otp += (input.value.length) ? input.value : ' ';
		return otp;
	  }, "");
	  document.querySelector("input[name=otp]").value = inputValue;
	}
})();

function paste() {
	let inputOtp_1 = document.querySelector('[name="otp_1"]'),
		inputOtp_2 = document.querySelector('[name="otp_2"]'),
		inputOtp_3 = document.querySelector('[name="otp_3"]'),
		inputOtp_4 = document.querySelector('[name="otp_4"]'),
		inputOtp_5 = document.querySelector('[name="otp_5"]'),
		inputOtp_6 = document.querySelector('[name="otp_6"]')

	inputOtp_1.classList.add("success");
	inputOtp_2.classList.add("success");
	inputOtp_3.classList.add("success");
	inputOtp_4.classList.add("success");
	inputOtp_5.classList.add("success");
	inputOtp_6.classList.add("success");
}

(function () {
	const inputsPassword = document.querySelectorAll("#otp-field-password input");
  
	for (let i = 0; i < inputsPassword.length; i++) {
	  const input = inputsPassword[i];
  
	  input.addEventListener("input", function () {
		// handling normal input
		if (input.value.length == 1 && i+1 < inputsPassword.length) {
		  inputsPassword[i+1].focus();
		}
  
		// if a value is pasted, put each character to each of the next input
		if (input.value.length > 1) {
		  // sanitise input
		  if (isNaN(input.value)) {
			input.value = "";
			updateInput();
			return;
		  }
  
		  // split characters to array
		  const chars = input.value.split('');
  
		  for (let pos = 0; pos < chars.length; pos++) {
			// if length exceeded the number of inputsPassword, stop
			if (pos + i >= inputsPassword.length) break;
  
			// paste value
			let targetInput = inputsPassword[pos + i];
			targetInput.value = chars[pos];
		  }
  
		  // focus the input next to the last pasted character
		  let focus_index = Math.min(inputsPassword.length - 1, i + chars.length);
		  inputsPassword[focus_index].focus();
		}
		updateInput();
	  });
  
	  input.addEventListener("keydown", function (e) {
		// backspace button
		if (e.keyCode == 8 && input.value == '' && i != 0) {
		  // shift next values towards the left
		  for (let pos = i; pos < inputsPassword.length - 1; pos++) {
			inputsPassword[pos].value = inputsPassword[pos + 1].value;
		  }
  
		  // clear previous box and focus on it
		  inputsPassword[i-1].value = '';
		  inputsPassword[i-1].focus();
		  updateInput();
		  return;
		}
  
		// delete button
		if (e.keyCode == 46 && i != inputsPassword.length - 1) {
		  // shift next values towards the left
		  for (let pos = i; pos < inputsPassword.length - 1; pos++) {
			inputsPassword[pos].value = inputsPassword[pos + 1].value;
		  }
  
		  // clear the last box
		  inputsPassword[inputsPassword.length - 1].value = '';
		  input.select();
		  e.preventDefault();
		  updateInput();
		  return;
		}
  
		// left button
		if (e.keyCode == 37) {
		  if (i > 0) {
			e.preventDefault();
			inputsPassword[i-1].focus();
			inputsPassword[i-1].select();
		  }
		  return;
		}
  
		// right button
		if (e.keyCode == 39) {
		  if (i+1 < inputsPassword.length) {
			e.preventDefault();
			inputsPassword[i+1].focus();
			inputsPassword[i+1].select();
		  }
		  return;
		}
	  });
	}
	
	function updateInput() {
	  let inputValue = Array.from(inputsPassword).reduce(function (otp, input) {
		otp += (input.value.length) ? input.value : ' ';
		return otp;
	  }, "");
	  document.querySelector("input[name=otp-password]").value = inputValue;
	}
})();

//Timer OTP
var timeInSecs;
var ticker;

function startTimer(secs) {
	timeInSecs = parseInt(secs);
	ticker = setInterval("tick()", 1000); 
}

function tick( ) {
	var secs = timeInSecs;
	if (secs > 0) {
		timeInSecs--; 
		$('.link-otp').addClass('disabled'); 
		$('.link-otp').prop("disabled", true);
	}
	else {
		clearInterval(ticker);
		// startTimer(5*60); // 4 minutes in seconds
		$('.link-otp').removeClass('disabled'); 
		$('.link-otp').prop("disabled", false);
	}

	var mins = Math.floor(secs/60);
	secs %= 60;
	var pretty = ( (mins < 10) ? "0" : "" ) + mins + ":" + ( (secs < 10) ? "0" : "" ) + secs;

	document.getElementById("timer").innerHTML = pretty;
}

// startTimer(5*60); // 4 minutes in seconds

function resettimerOTP() {
	startTimer(5*60);
}