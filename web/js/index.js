/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


/*Cabecera*/
var header= document.querySelector('.cabecera_nuevo');
var desaparecer = document.querySelector('.cabecera_desaparecer');

window.addEventListener('scroll', ()=>{
    var scroll=window.scrollY;

    if( scroll>10 && scroll<696){
        header.style.backgroundColor = 'rgba(100,5,0,0.6)';
        header.style.zIndex = "999999";
        header.style.top = '-1px';
        header.style.borderBottom='2px solid white';
        

    } else if (scroll>696) {
        header.style.backgroundColor = '#f80000';
        header.style.top = '-1px';
        header.style.borderBottom='2px solid white';
        
    } else if (scroll<10){
        header.style.removeProperty('top');
    }

});