
let space = '\u00A0';

$("#recipientCountryList").on('change', ()=> {
    let recipientCountry = $("#recipientCountryList").val();
    $(".errorMsg").text("");

    let data ={};
    data.recipientCountry = recipientCountry;
    $.ajax({
        url : "/ajax/requestExchangeRate",
        type : "post",
        contentType : "application/json",
        data : JSON.stringify(data),
        dataType : "json"
    }).done(res=>{
        console.log(res);
        let data = res.data.quotes;
        let value = Object.keys(data)[0];

        $("#exchangeRate").text(exchangeRateFormat(data[value]) + space);
        $(".item").find("dd").text(recipientCountry);
    }).fail(error=>{
        console.log(error);
        let data = error.responseJSON;

        if(data.code == 9999) $(".errorMsg").text(data.message);
        else if(data.code == 9000) $(".errorMsg").text(data.data.recipientCountry);
        else $(".errorMsg").text("처리중 오류가 발생했습니다.")
    });
});

function exchangeRateFormat(data){
    return amountUnit(data.toFixed(2));
}

function amountUnit(data){
    return data.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
}
