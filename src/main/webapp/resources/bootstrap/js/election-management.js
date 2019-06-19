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



    $("#datepicker1").on("dp.change", function (e) {
        $('#datepicker4').data("DateTimePicker").minDate(e.date);
    });
    $("#datepicker1").on("dp.change", function (e) {
        $('#datepicker3').data("DateTimePicker").minDate(e.date);
    });
    $("#datepicker1").on("dp.change", function (e) {
        $('#datepicker2').data("DateTimePicker").minDate(e.date);
    });

    $("#datepicker2").on("dp.change", function (e) {
        $('#datepicker1').data("DateTimePicker").maxDate(e.date);
    });
    $("#datepicker2").on("dp.change", function (e) {
        $('#datepicker4').data("DateTimePicker").minDate(e.date);
    });
    $("#datepicker2").on("dp.change", function (e) {
        $('#datepicker3').data("DateTimePicker").minDate(e.date);
    });

    $("#datepicker3").on("dp.change", function (e) {
        $('#datepicker4').data("DateTimePicker").minDate(e.date);
    });

    $("#datepicker4").on("dp.change", function (e) {
        $('#datepicker3').data("DateTimePicker").maxDate(e.date);
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
var click = true;
$('button').on('click', function(node) {
    if(click) {
        click = !click;

        setTimeout(function () {
            click = true;
        }, 1000);

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

        if (type === 'general') {
            type = 1;
        } else if (type === 'department') {
            type = 2;
        } else if (type === 'major') {
            type = 3;
        }

        $.ajax({
            url: "electionManagement",
            type: "POST",
            contentType: 'application/json',
            data: {
                name: generation,
                voteStartDate: voteStart,
                voteEndDate: voteEnd,
                type: type,
                regStartDate: regStart,
                regEndDate: regEnd
            },
            success: function () {
                alert("저장되었습니다.");
            }
        });
    }
});