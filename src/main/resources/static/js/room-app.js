const addRoom = async (event, form) => {

    event.preventDefault();
    const formData = new FormData(form);
    var bodyArr = {};
    formData.forEach(function(value, key){
        bodyArr[key] = value;
    });

    var body = JSON.stringify(bodyArr);

    await fetch('rest/admin/roomType', {
        method: 'POST',
        body: body, // string or object
        headers: {
          'Content-Type': 'application/json'
        }})
        .then(response => {
          if (!response.ok) {
            throw new Error('Network response was not ok');
          }

          return response.json();
        })
        .then(roomData => {
          // Process the retrieved room data

          alert("Room data saved successfully..");
          location.reload();
          console.log('Room Data:', roomData);
        })
        .catch(error => {
          console.error('Error:', error);
          alert(error);
        });
}

const bookRoom = async (event, guests, checkIn, checkOut, roomId, roomCount) => {

    event.preventDefault();

    var bodyArr = {};
    bodyArr["guests"] = guests;
    bodyArr["checkIn"] = checkIn;
    bodyArr["checkOut"] = checkOut;
    bodyArr["roomId"] = roomId;
    bodyArr["roomCount"] = roomCount;

    var url = '';
    for (var key in bodyArr) {
        if (url !='') {
            url = url + '&';
        }
        var value = bodyArr[key];
        url = url + key + '=' + value;
    }
    window.location.replace("room-booking-summary?" + url);

    alert(body);
}

const proceedPayment = async (event, guests, checkIn, checkOut, roomId, roomCount) => {

    event.preventDefault();

    var bodyArr = {};
    bodyArr["guests"] = guests;
    bodyArr["checkIn"] = checkIn;
    bodyArr["checkOut"] = checkOut;
    bodyArr["roomId"] = roomId;
    bodyArr["roomCount"] = roomCount;

    var url = '';
    for (var key in bodyArr) {
        if (url !='') {
            url = url + '&';
        }
        var value = bodyArr[key];
        url = url + key + '=' + value;
    }
    window.location.replace("proceed-payment?" + url);

    alert(body);
}