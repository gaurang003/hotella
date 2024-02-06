

var today = new Date();
var day = today.getDate();

console.log('todays date'+ today);


    let menuicn = document.querySelector("#menuicn");
     let nav = document.querySelector(".navcontainer");

     menuicn.addEventListener("click", () => {
         nav.classList.toggle("navclose");
     })