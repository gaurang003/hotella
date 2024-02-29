
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
            return response.text().then(text => { throw new Error(text) });
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
            alert(error.message);
//          console.error('Error:', error);
        });
}


const addFoodCategory = async (event, form) => {

    event.preventDefault();
    const formData = new FormData(form);
    var bodyArr = {};
    formData.forEach(function(value, key){
        bodyArr[key] = value;
    });

    var body = JSON.stringify(bodyArr);

    await fetch('rest/admin/category', {
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
        .then(foodCategoryData => {
          // Process the retrieved food Category data
          alert("Food Category data saved successfully..");
          location.reload();
          console.log('Food Category Data:', foodCategoryData);
        })
        .catch(error => {
          console.error('Error:', error);
        });
}