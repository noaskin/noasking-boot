(function() {
    var url = "http://localhost:8080/mldesk/secondaryFiveElementRadio.do";

    var data = {
        "userId": 123,
        "userName": "wangdachui"
    };
    $.ajax({
        url: url,
        type: 'POST',
        dataType: 'json',
        data: $.toJSON(data),
        contentType: 'application/json'
    }).done(function(result) {
        console.log("success");
        console.log(result);
    }).fail(function() {
        console.log("error");
    })
})()