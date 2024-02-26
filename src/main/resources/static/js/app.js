function addFood() {

    alert("add food clicked.");

    var foodForm = $("#foodForm")[0];
    const body = {

    };

    var formData = new FormData(foodForm);

    $.post("addFood", body, (data, status) => {
        console.log(data);
    });
}