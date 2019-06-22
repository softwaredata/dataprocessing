$(document).ready(function(){
    $('.dateTimePicker').datetimepicker({format:"YYYY-MM-DD HH:mm"});
    $('#datepicker1').datetimepicker({
        timePicker: true,
        autoUpdateInput: false,
        //useCurrent: false,
        autoclose: true,
        calendarWeeks: false
    });
    $('#datepicker2').datetimepicker({
        autoUpdateInput: false,
        autoclose: true,
        useCurrent: false
    });
    $('#datepicker3').datetimepicker({
        autoUpdateInput: false,
        autoclose: true,
        useCurrent: false
    });
    $('#datepicker4').datetimepicker({
        autoUpdateInput: false,
        autoclose: true,
        useCurrent: false
    });
<<<<<<< HEAD
    $('#datepicker5').datetimepicker({
        autoUpdateInput: false,
        autoclose: true,
        useCurrent: false
    });
    $('#datepicker6').datetimepicker({
        autoUpdateInput: false,
        autoclose: true,
        useCurrent: false
    });
    $('#datepicker7').datetimepicker({
        autoUpdateInput: false,
        autoclose: true,
        useCurrent: false
    });
    $('#datepicker8').datetimepicker({
        autoUpdateInput: false,
        autoclose: true,
        useCurrent: false
    });
    $('#datepicker9').datetimepicker({
        autoUpdateInput: false,
        autoclose: true,
        useCurrent: false
    });
    $('#datepicker10').datetimepicker({
        autoUpdateInput: false,
        autoclose: true,
        useCurrent: false
    });
    $('#datepicker11').datetimepicker({
        autoUpdateInput: false,
        autoclose: true,
        useCurrent: false
    });$('#datepicker12').datetimepicker({
        autoUpdateInput: false,
        autoclose: true,
        useCurrent: false
    });
=======
    // $('#datepicker5').datetimepicker({
    //     autoUpdateInput: false,
    //     autoclose: true,
    //     useCurrent: false
    // });
    // $('#datepicker6').datetimepicker({
    //     autoUpdateInput: false,
    //     autoclose: true,
    //     useCurrent: false
    // });
    // $('#datepicker7').datetimepicker({
    //     autoUpdateInput: false,
    //     autoclose: true,
    //     useCurrent: false
    // });
    // $('#datepicker8').datetimepicker({
    //     autoUpdateInput: false,
    //     autoclose: true,
    //     useCurrent: false
    // });
    // $('#datepicker9').datetimepicker({
    //     autoUpdateInput: false,
    //     autoclose: true,
    //     useCurrent: false
    // });
    // $('#datepicker10').datetimepicker({
    //     autoUpdateInput: false,
    //     autoclose: true,
    //     useCurrent: false
    // });
    // $('#datepicker11').datetimepicker({
    //     autoUpdateInput: false,
    //     autoclose: true,
    //     useCurrent: false
    // });$('#datepicker12').datetimepicker({
    //     autoUpdateInput: false,
    //     autoclose: true,
    //     useCurrent: false
    // });
>>>>>>> e71a403a1e507f5de6bb2c848dbbf87c1bfb1404



    $("#datepicker1").on("dp.change", function (e) {
        $('#datepicker4').data("DateTimePicker").minDate(e.date);
<<<<<<< HEAD
=======
        $("#datepicker1").data("regStart", e.date.toString());
>>>>>>> e71a403a1e507f5de6bb2c848dbbf87c1bfb1404
    });
    $("#datepicker1").on("dp.change", function (e) {
        $('#datepicker3').data("DateTimePicker").minDate(e.date);
    });
    $("#datepicker1").on("dp.change", function (e) {
        $('#datepicker2').data("DateTimePicker").minDate(e.date);
    });

    $("#datepicker2").on("dp.change", function (e) {
        $('#datepicker1').data("DateTimePicker").maxDate(e.date);
<<<<<<< HEAD
=======
        $("#datepicker2").data("regEnd", e.date.toString());
>>>>>>> e71a403a1e507f5de6bb2c848dbbf87c1bfb1404
    });
    $("#datepicker2").on("dp.change", function (e) {
        $('#datepicker4').data("DateTimePicker").minDate(e.date);
    });
    $("#datepicker2").on("dp.change", function (e) {
        $('#datepicker3').data("DateTimePicker").minDate(e.date);
    });

    $("#datepicker3").on("dp.change", function (e) {
        $('#datepicker4').data("DateTimePicker").minDate(e.date);
<<<<<<< HEAD
=======
        $("#datepicker3").data("voteStart", e.date.toString());
>>>>>>> e71a403a1e507f5de6bb2c848dbbf87c1bfb1404
    });

    $("#datepicker4").on("dp.change", function (e) {
        $('#datepicker3').data("DateTimePicker").maxDate(e.date);
<<<<<<< HEAD
    });


    $("#datepicker5").on("dp.change", function (e) {
        $('#datepicker8').data("DateTimePicker").minDate(e.date);
    });
    $("#datepicker5").on("dp.change", function (e) {
        $('#datepicker7').data("DateTimePicker").minDate(e.date);
    });
    $("#datepicker5").on("dp.change", function (e) {
        $('#datepicker6').data("DateTimePicker").minDate(e.date);
    });

    $("#datepicker6").on("dp.change", function (e) {
        $('#datepicker5').data("DateTimePicker").maxDate(e.date);
    });
    $("#datepicker6").on("dp.change", function (e) {
        $('#datepicker8').data("DateTimePicker").minDate(e.date);
    });
    $("#datepicker6").on("dp.change", function (e) {
        $('#datepicker7').data("DateTimePicker").minDate(e.date);
    });


    $("#datepicker7").on("dp.change", function (e) {
        $('#datepicker8').data("DateTimePicker").minDate(e.date);
    });

    $("#datepicker8").on("dp.change", function (e) {
        $('#datepicker7').data("DateTimePicker").maxDate(e.date);
    });


    $("#datepicker9").on("dp.change", function (e) {
        $('#datepicker12').data("DateTimePicker").minDate(e.date);
    });
    $("#datepicker9").on("dp.change", function (e) {
        $('#datepicker11').data("DateTimePicker").minDate(e.date);
    });
    $("#datepicker9").on("dp.change", function (e) {
        $('#datepicker10').data("DateTimePicker").minDate(e.date);
    });

    $("#datepicker10").on("dp.change", function (e) {
        $('#datepicker9').data("DateTimePicker").maxDate(e.date);
    });
    $("#datepicker10").on("dp.change", function (e) {
        $('#datepicker12').data("DateTimePicker").minDate(e.date);
    });
    $("#datepicker10").on("dp.change", function (e) {
        $('#datepicker11').data("DateTimePicker").minDate(e.date);
    });

    $("#datepicker11").on("dp.change", function (e) {
        $('#datepicker12').data("DateTimePicker").minDate(e.date);
    });

    $("#datepicker12").on("dp.change", function (e) {
        $('#datepicker11').data("DateTimePicker").maxDate(e.date);
    });
});


$('button').on('click', function(node) {
    console.log('들어옴');
    var button = node.target;
    var div = button.parentNode;
    console.log(button);
    console.log(div);

    var type = div.id;
    var generation = div.getElementsByClassName('generation').value;
    var children = div.getElementsByClassName('form-control');
    var voteStart = children[0].getAttribute('value');
    var voteEnd = children[1].getAttribute('value');
    var regStart = children[2].getAttribute('value');
    var regEnd = children[3].getAttribute('value');

    console.log('type ' + type);
    console.log('generation ' + generation);
    console.log('children ' + children);
    console.log('voteStart ' + voteStart);
    console.log('voteEnd ' + voteEnd);
    console.log('regStart ' + regStart);
    console.log('regEnd ' + regEnd);

    if(type === 'general') {
        type = 1;
    } else if(type === 'department') {
        type = 2;
    } else if(type === 'major') {
        type = 3;
    }

    $.ajax({
        url : "electionManagement",
        type : "POST",
        contentType: 'application/json',
        data : {
            name : generation,
            voteStartDate : voteStart,
            voteEndDate : voteEnd,
            type : type,
            regStartDate : regStart,
            regEndDate : regEnd
        },
        success : function() {
            alert("저장되었습니다.");
        }
    });
=======
        $("#datepicker4").data("voteEnd", e.date.toString());
    });


    // $("#datepicker5").on("dp.change", function (e) {
    //     $('#datepicker8').data("DateTimePicker").minDate(e.date);
    // });
    // $("#datepicker5").on("dp.change", function (e) {
    //     $('#datepicker7').data("DateTimePicker").minDate(e.date);
    // });
    // $("#datepicker5").on("dp.change", function (e) {
    //     $('#datepicker6').data("DateTimePicker").minDate(e.date);
    // });
    //
    // $("#datepicker6").on("dp.change", function (e) {
    //     $('#datepicker5').data("DateTimePicker").maxDate(e.date);
    // });
    // $("#datepicker6").on("dp.change", function (e) {
    //     $('#datepicker8').data("DateTimePicker").minDate(e.date);
    // });
    // $("#datepicker6").on("dp.change", function (e) {
    //     $('#datepicker7').data("DateTimePicker").minDate(e.date);
    // });
    //
    //
    // $("#datepicker7").on("dp.change", function (e) {
    //     $('#datepicker8').data("DateTimePicker").minDate(e.date);
    // });
    //
    // $("#datepicker8").on("dp.change", function (e) {
    //     $('#datepicker7').data("DateTimePicker").maxDate(e.date);
    // });
    //
    //
    // $("#datepicker9").on("dp.change", function (e) {
    //     $('#datepicker12').data("DateTimePicker").minDate(e.date);
    // });
    // $("#datepicker9").on("dp.change", function (e) {
    //     $('#datepicker11').data("DateTimePicker").minDate(e.date);
    // });
    // $("#datepicker9").on("dp.change", function (e) {
    //     $('#datepicker10').data("DateTimePicker").minDate(e.date);
    // });
    //
    // $("#datepicker10").on("dp.change", function (e) {
    //     $('#datepicker9').data("DateTimePicker").maxDate(e.date);
    // });
    // $("#datepicker10").on("dp.change", function (e) {
    //     $('#datepicker12').data("DateTimePicker").minDate(e.date);
    // });
    // $("#datepicker10").on("dp.change", function (e) {
    //     $('#datepicker11').data("DateTimePicker").minDate(e.date);
    // });
    //
    // $("#datepicker11").on("dp.change", function (e) {
    //     $('#datepicker12').data("DateTimePicker").minDate(e.date);
    // });
    //
    // $("#datepicker12").on("dp.change", function (e) {
    //     $('#datepicker11').data("DateTimePicker").maxDate(e.date);
    // });
});

// document.getElementsByClassName('input-group-addon').addEventListener('click' , function (ev) {
//     //document.getElementById('clickMe').addEventListener('click', onClick);
//     ev.getElementsByName('regStartDate').setAttribute('value',$('#datepicker1').data("DateTimePicker") );
//     console.log(document.getElementsByName('regStartDate').value);
//     document.getElementsByName('regEndDate').setAttribute('value',$('#datepicker2').data("DateTimePicker") );
//     document.getElementsByName('voteStartDate').setAttribute('value',$('#datepicker3').data("DateTimePicker") );
//     document.getElementsByName('voteEndDate').setAttribute('value',$('#datepicker4').data("DateTimePicker") );
// });

// function getFormatDate(date){
//     var year = date.getFullYear();
// 	var month = (1 + date.getMonth());
//     month = month >= 10 ? month : '0' + month;
//     var day = date.getDate();
//     day = day >= 10 ? day : '0' + day;
//     return year + '-' + month + '-' + day;
// }

function formatDate(date) {
    var d = new Date(date);
        month = '' + (d.getMonth() + 1);
        day = '' + d.getDate();
        year = '' + d.getFullYear();

        hour = '' + d.getHours();
        minute = '' + d.getMinutes();
        second = '' + d.getSeconds();

    if (month.length < 2)
        month = '0' + month;

    if (day.length < 2)
        day = '0' + day;

    if(hour.length < 2)
        hour = '0' + hour;

    if(minute.length < 2)
        minute = '0' + minute;

    if(second.length < 2)
        second = '0' + second;

    return year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + second;
}

var click = true;
$('button').on('click', function() {
    if(click) {
        click = !click;

        setTimeout(function() {
            click = true;
        }, 1000);

        var generation = document.getElementById('name').value;
        var voteStart = $('#datepicker3').data("voteStart");
        var voteEnd = $('#datepicker4').data("voteEnd");
        var regStart = $('#datepicker1').data("regStart");
        var regEnd = $('#datepicker2').data("regEnd");
        var title = document.getElementById('title').innerText;
        var department = document.getElementById('category').value;

        console.log($('#datepicker3').data("voteStart") === undefined);



        if(regStart === undefined) {
            regStart = document.getElementById('regStartDate').value + ':00';
        } else {
            regStart = formatDate(regStart);
        }

        if(regEnd === undefined) {
            regEnd = document.getElementById('regEndDate').value + ':00';
        } else {
            regEnd = formatDate(regEnd);
        }

        if(voteStart === undefined) {
            voteStart = document.getElementById('voteStartDate').value + ':00';
        } else {
            voteStart = formatDate(voteStart);
        }

        if(voteEnd === undefined) {
            voteEnd = document.getElementById('voteEndDate').value + ':00';
        } else {
            voteEnd = formatDate(voteEnd);
        }

        console.log(voteStart);
        console.log(voteEnd);
        console.log(regStart);
        console.log(regEnd);

        $.ajax({
            url: "electionManagement",
            type: "POST",
            contentType: 'application/json',
            data: JSON.stringify({
                title: title,
                name: generation,
                voteStartDate: voteStart,
                voteEndDate: voteEnd,
                regStartDate: regStart,
                regEndDate: regEnd,
                department: department
            })
            // success: function () {
            //     alert("저장되었습니다.");
            // }
        });
     }
>>>>>>> e71a403a1e507f5de6bb2c848dbbf87c1bfb1404
});