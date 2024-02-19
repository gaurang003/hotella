

var today = new Date();
var day = today.getDate();

console.log('todays date'+ today);

var roomBooking = function() {

    console.log("clicked on room booking");
    alert("clicked on room booking");
}

console.log("JS loaded");

function checkInChanged(event){

   let checkInDt = $('#checkIn')[0].value;
   let checkOutDt = $('#checkOut')[0];
   checkOutDt.min = checkInDt;
}