
document.addEventListener("DOMContentLoaded", function() {
var color= document.getElementsByClassName('contenedor_reservar_detalles_title');


var imagen = document.querySelectorAll('.probar');
var imagen_detalle_compra = document.querySelectorAll('.contenedor_reservar_detalles');


function aplicarEfecto(event) {
    var imagen2=event.target;
    imagen2.style.opacity = "0.7"; 
    imagen2.style.filter = "saturate(150%) hue-rotate(30deg)";
  }

  

  function eliminarEfecto(event) {
    var imagen2=event.target;
    imagen2.style.opacity = "1"; 
    imagen2.style.filter = "none";
    
  }


  
  function aplicarEfecto2(event) {
    var imagen3=event.target;
    imagen3.style.opacity = "100%";
    imagen3.style.zIndex = "9999";
    imagen3.style.filter = "none";
  }

  function eliminarEfecto2(event) {
    var imagen3=event.target;
    imagen3.style.opacity = "0"; 
    imagen3.style.filter = "none";
  }
  
  imagen.forEach(function(imagen2){
    imagen2.addEventListener("mouseenter", aplicarEfecto);
    imagen2.addEventListener("mouseleave", eliminarEfecto); 
  });

  imagen_detalle_compra.forEach(function(imagen3){
    imagen3.addEventListener("mouseenter", aplicarEfecto2);
    imagen3.style.zIndex = "9999";
    imagen3.addEventListener("mouseleave", eliminarEfecto2);
});


/*imagen.style.opacity = "0.7"; 


imagen.style.filter = "saturate(150%) hue-rotate(200deg)";*/


/* PELICULAS MOSTRAR */
var boton = document.querySelector('.content_ver_mas_div');
var contador = 3;
var final = 0;
var boton2 = document.querySelector('.content_ver_menos_div');

boton.onclick = () => {
  var boxes = [...document.querySelectorAll('.box-container .box-1')];

  for (var i = final; i < final + 3 && i < boxes.length; i++) {
    boxes[i].style.display = "inline-block";
  }

  final += 3;

  if (final >= boxes.length) {
    boton.style.display = 'none';
    boton2.style.display = 'block';
  }

  
};

boton2.onclick = () => {
  var boxes = [...document.querySelectorAll('.box-container .box-1')];

  for (var i = final - 1; i >= final - 3 && i >= 3; i--) {
    boxes[i].style.display = "none";
  }

  final -= 3;

  if (final <= 3) {
    boton2.style.display = 'none';
    boton.style.display = 'block';
    
  }

 
};



/*CARGAR CATEGORIA */
/*ACCION */
// FILTRA PELICULAS 




var mostrar_3pelis = document.querySelectorAll('.box-1:nth-child(1), .box-1:nth-child(2), .box-1:nth-child(3)');


var btnMostrarTodo=document.querySelector('.content_ver_mas_div');
var btnMostrarFitro=document.querySelector('.selector_opciones_2');

btnMostrarFitro.addEventListener('click',function(){
  var btntodos = document.querySelectorAll('.box-1');
  btntodos.forEach(function(box) {
    box.style.display = 'none';
    btnMostrarTodo.style.display= "block";
            mostrar_3pelis.forEach(function(fun) {
              fun.style.display = 'block';
      });
  });
});


});