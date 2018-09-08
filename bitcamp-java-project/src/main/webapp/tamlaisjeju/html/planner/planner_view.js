 var link = document.location.href.split("?")[1];
 var viewDate = null;
 //템플릿 엔진이 사용할 템플릿 데이터 가져오기
 var trTemplateSrc = $("#tr-template").html();
 
 // 위에서 준비한 템플릿 데이터를 가지고 HTML을 생성할 템플릿 엔진 준비
 var templateFn = Handlebars.compile(trTemplateSrc);
 $(document).ready(function () {
	    var memberId;
	    var contentMember;

	    $.get(serverRoot + "/json/auth/islogin", {}, user => {
	        memberId = decodeURIComponent(user.id);
	        
	    })
 
 
 
 $.getJSON(serverRoot+"/json/planner/"+link, (data) => {
 	   viewDate = data;
 	   trHTML = templateFn(data);
       $(trHTML).appendTo('#tableBody');
       dayCal();
       hashTag();
});
 

$.getJSON(serverRoot + "/json/content/"+link, (data2) => {
    $('.plan_title')[0].textContent = data2.title,
    $('#delete_div').append(
            "<button id='list' type='button' class='btn btn-primary' OnClick='location.href'='planner_list.html'>목록으로</button>"
        )
    if (memberId == data2.id) {
             $('#delete_div').append(
            		 "<button id='update' type='button' class='btn btn-primary'>수정하기</button>" +
                 "<button type='button' class='btn btn-primary' id='planDelete'>삭제하기</button>"
             )
         }
    $('#list').click(function () {
        location.href = 'planner_list.html'
    })
    $('#planDelete').click(function () {
   	 $.ajax({
            type: "POST",
            url: serverRoot + "/json/travelPlan/delete?no="+link,
            success: function (data) {
           	 planDelete();
            },
            error: function (data) {
                alert("빈 칸을 채워주세요.");
            }

        });
   	 function planDelete() {
   	 $.ajax({
            type: "POST",
            url: serverRoot + "/json/planner/delete?no="+link,
            success: function (data) {
           	 hashDelete();
            },
            error: function (data) {
                alert("빈 칸을 채워주세요.");
            }

        });
   	 }
   	 function hashDelete() {
   		 $.ajax({
   	         type: "POST",
   	         url: serverRoot + "/json/hashTag/delete?no="+link,
   	         success: function (data) {
   	        	 contentDelete();
   	         },
   	         error: function (data) {
   	             alert("빈 칸을 채워주세요.");
   	         }

   	     });
   		 }
   	 function contentDelete() {
   	 $.ajax({
            type: "POST",
            url: serverRoot + "/json/content/delete?no="+link,
            success: function (data) {
                location.href = "planner_list.html";
            },
            error: function (data) {
                alert("빈 칸을 채워주세요.");
            }

        });
    
   	 }
    });
});
 });
 function hashTag() {
 $.getJSON(serverRoot + "/json/hashTag/"+link, (data3) => {
	for (var h = 0; h < data3.length; h++) {
	$('#hashTag').append(
			"<a style='z-index:9999;font-weight: bold;' target='_blank' href=../../search.html?"+data3[h].content+">"+data3[h].content+" <a>"
			)
	}
			/*	
	$('#thema')append(
			"<li class='plan_cont clear'>태그: {{memo}}</li>)
	}*/

});
 }
 
 