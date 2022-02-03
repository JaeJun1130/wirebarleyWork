
let space = '\u00A0';

let recipientCountry;
$("#recipientCountryList").on('change', ()=> {
    recipientCountry = $("#recipientCountryList").val();
    $(".errorMsg").remove();

    /**
     * 환율 정보 얻어올때는 amount의 값이 필요하지 않기때문에 Valid 체크를 통과하기 위해 1로 하드코딩
     */
    let data ={};
    data.recipientCountry = recipientCountry;
    data.amount = 1

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
        $("#country").text(recipientCountry);
    }).fail(error=>{
        let code = error.responseJSON.code;
        let errorMsg = error.responseJSON.data;

        if(code == 9999) {
            $(".errorContainer").append(`<span class="errorMsg">${errorMsg.message}</span>`)
        }else if(code == 9000){
            for(msg in errorMsg){
                $(".errorContainer").append(`<span class="errorMsg">${errorMsg[msg]}</span>`)
            }
        }else{
            $(".errorContainer").append(`<span class="errorMsg">처리중 오류가 발생했습니다.</span>`)
        }
    });
});

function receiptAmountCalculate() {
    let data ={};
    data.recipientCountry = recipientCountry;
    data.amount = $("#amount").val();
    $(".errorMsg ").remove();
    $(".resMsg").remove();

    $.ajax({
        url : "/ajax/requestExchangeRate/calculate",
        type : "post",
        contentType : "application/json",
        data : JSON.stringify(data),
        dataType : "json"
    }).done(res=>{
        console.log(res.data);

        $(".resContainer").append(`<span class="resMsg">수취금액은 ${exchangeRateFormat(res.data)} ${$("#country").text()} 입니다.</span>`)
    }).fail(error=>{
        let code = error.responseJSON.code;
        let errorMsg = error.responseJSON.data;

        if(code == 9999) {
            $(".errorContainer").append(`<span class="errorMsg">${errorMsg.message}</span>`)
        }else if(code == 9000){
            for(msg in errorMsg){
                $(".errorContainer").append(`<span class="errorMsg">${errorMsg[msg]}</span>`)
            }
        }else{
            $(".errorContainer").append(`<span class="errorMsg">처리중 오류가 발생했습니다.</span>`)
        }
    });
}

function exchangeRateFormat(data){
    return amountUnit(data.toFixed(2));
}

function amountUnit(data){
    return data.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
}
