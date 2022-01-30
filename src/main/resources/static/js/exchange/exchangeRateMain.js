
$("#countryList").on('change', ()=> {
    let data = $("#countryList").val();
    $(".item").find("dd").text(data);

    $.ajax({
        url : "/ajax/requestExchangeRate",
        type : "post",
        contentType : "application/json",
        data : JSON.stringify(),
        dataType : "json"
    }).done(res=>{
        console.log(res);
    }).fail(error=>{
        console.log(error);
    });
});