var serverRoot = "http://kimbokjin.com:8888/pms";


$.get(serverRoot + "/json/auth/islogin", {}, user => {
	let name = decodeURIComponent(user);
	if(name != "n") {
		console.log(name);
		$("#Login").css("display", "none");
		$("#Logout").css("display", "block");
		$("#UserName").textContent = name;
	}
})