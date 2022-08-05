$(document).on('ready', function(){
    $("#roundtrip").on("click", function(){
        $("#ocultar").css("display", "block");
    });

    $("#one-way").on("click", function(){
        $("#ocultar").css("display", "none");
    });
});
