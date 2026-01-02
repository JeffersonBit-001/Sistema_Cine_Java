/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


/*Sub categoria*/
    buttonsubcat = document.querySelectorAll('.btnselecsubcat');
    contentDivsubcat = document.querySelectorAll('.div_comb_beb_dul');

    buttonsubcat.forEach(button => {
        button.addEventListener('click', () => {
            selectedsub = button.getAttribute('data-subcat');

            contentDivsubcat.forEach(div => {
                if (div.getAttribute('data-subcat') === selectedsub) {
                    div.style.display = 'block';
                } else {
                    div.style.display = 'none';
                }
            });
            
            console.log(`${selectedsub.charAt(0).toUpperCase() + selectedsub.slice(1)} seleccionada`);
        });
    });
    