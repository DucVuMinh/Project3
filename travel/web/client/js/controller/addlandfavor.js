/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    $("#btaddfavor").click(function(){
        var url = window.location.href;
        var idposts = url.split('?')[1].split('=')[1];
        $.post("addlandfavor.htm",
        {
          idpost: idposts
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
            }else if(data==="added"){
                var popup = document.getElementById('addedfavor');
                popup.classList.toggle('show');
            }else {
                var popup = document.getElementById('doneaddfavor');
                popup.classList.toggle('show');
            }
        });
    });
});
