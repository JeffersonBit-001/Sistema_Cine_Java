var inputSerach2 = document.getElementById("input-search-ser");
var box_search2 = document.getElementById("ul_edit");

/* Filtrar busqueda*/
function buscador2(){
    var filter = inputSerach2.value.toUpperCase();
    
    /*almacenar resultados - todas las etiquetas del recadro*/
    var li = box_search2.getElementsByTagName("li");
    /*Recorriendo elementos a filtrar */
    for (i=0;i<li.length;i++){
        let a = li[i].getElementsByTagName("a")[0];
        let textValue = a.textContent || a.innerText;

        if(textValue.toUpperCase().indexOf(filter) >-1){
            li[i].style.display = "";
            box_search2.style.display = "block";

            if (inputSerach2.value===""){
                box_search2.style.display = "none";
            }

        } else {
            li[i].style.display = "none";
        }
    }


}


/*ejecutar mientras escribe*/
document.getElementById("input-search-ser").addEventListener("keyup",buscador2);