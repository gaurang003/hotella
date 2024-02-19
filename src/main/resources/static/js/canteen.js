
    $(document).ready(function() {
    $('select').change(function() {
        var total = 0;
        $('select').each(function() {
            total += parseFloat($(this).val());
        });
        $('#totalPrice').text(total.toFixed(2));
    });
});


