"use strict";
let avatarImgs = document.querySelectorAll(".avatar img");
let avatarRadios = document.querySelectorAll(".avatar input");
let fetchedPictures = [];
$.ajax({
	url: "https://randomuser.me/api/?lego&results=" + 50, dataType: "json", cache: false, success: function (data) {
		data.results.forEach(result => {
			if (!fetchedPictures.includes(result.picture.thumbnail)) {
				fetchedPictures.push(result.picture.thumbnail);
			}
		});
		avatarImgs.forEach((img, imgIndex) => {
			img.src = fetchedPictures[imgIndex];
		});
		avatarRadios.forEach((radio, radioIndex) => {
			radio.value = fetchedPictures[radioIndex];
			radio.addEventListener("change", () => {
				avatarImgs.forEach((img, imgIndex) => {
					img.classList.remove("profileImgSelect");
					if (imgIndex === radioIndex) {
						img.classList.add("profileImgSelect");
					}
				});
			});
		});
	}
});

function showProfPics() {
	if (document.getElementById("truckCheck").checked === true) {
		document.getElementById("avatar-choices").hidden = true;
	} else if (document.getElementById("userCheck").checked === true) {
		document.getElementById("avatar-choices").hidden = false;
	}
}