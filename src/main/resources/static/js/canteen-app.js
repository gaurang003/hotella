
const addFoodOld = (event, form) => {

    event.preventDefault();

    const formData = new FormData(form);
        var body = {};
        formData.forEach(function(value, key){
            object[key] = value;
        });
        var json = JSON.stringify(object);


  fetch('admin/rest')
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      return response.json();
    })
    .then(userData => {
      // Process the retrieved user data
      console.log('User Data:', userData);
    })
    .catch(error => {
      console.error('Error:', error);
    });
}

const addFood = async (event, form) => {

    event.preventDefault();
    const formData = new FormData(form);
    var bodyArr = {};
    formData.forEach(function(value, key){
        bodyArr[key] = value;
    });

    var body = JSON.stringify(bodyArr);

    await fetch('rest/admin/food', {
        method: 'POST',
        body: body, // string or object
        headers: {
            'Content-Type': 'application/json'
        }})
        .then(response => {
          if (!response.ok) {
            let msg = response.errors;
            throw new Error('Network response was not ok');
          }
          return response.json();
        })
        .then(foodData => {
          // Process the retrieved food data
          alert("Food data saved successfully..");
          location.reload();
          console.log('Food Data:', foodData);
        })
        .catch(error => {
          console.error('Error:', error);
        });
}