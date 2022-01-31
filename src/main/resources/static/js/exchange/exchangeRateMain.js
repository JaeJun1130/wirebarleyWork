
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
        // let data = res.data.body.quotes;
        // for(let i in data) {
        //     console.log(i); // key
        //     console.log(numberWithCommas(data[i])); // value against the key
        // }
    }).fail(error=>{
        console.log(error);
    });
});

function numberWithCommas(num) {
    var parts = num.toString().split(".");
    return parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",") + (parts[1] ? "." + parts[1] : "");
}