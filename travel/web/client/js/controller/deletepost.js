/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $(".deletepost").click(function (e) {
        bootbox.confirm({
            message: "Bạn có muốn xóa bài viết?",
            callback: function (result) {
                if (result)
                    deletep(e);
            }
        });
    });
});
function deletep(e) {
    var id=e.target.id.split("_")[1];
    $.post("cusdeleteposts.htm",
        {
          idpost: id
        },
        function(data,status){
            if (data === "login") {
                var popup = document.getElementById('loginfavor');
                popup.classList.toggle('show');
            } else if (data === "waitadmin") {
                var popup = document.getElementById('waitadminfavor');
                popup.classList.toggle('show');
            }else if(data === "error"){
                var popup = document.getElementById('errorpagefavor');
                popup.classList.toggle('show');
            }else {
                var p = document.getElementById(id);
                p.style.visibility = "hidden";
            }
        });
}
;

