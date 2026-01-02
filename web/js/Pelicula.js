/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


document.getElementById('playVideo').addEventListener('click', function() {
    var iframeContainer = document.querySelector('.content_iframe');
    var iframe = iframeContainer.querySelector('.iframe');
    var btn = document.querySelector('.btn_selector');
    
    
    iframeContainer.style.display = 'block';
    
    var videoUrl = String(iframe.getAttribute('src')) + '&autoplay=1';

    iframe.src = videoUrl;

    btn.style.display='none';
});

function registerVideoEvents() {
    var iframe = document.querySelector('.iframe');
    iframe.contentWindow.document.querySelector('video').addEventListener('ended', function() {
        
        console.log("El video ha terminado de reproducirse.");
    });
}