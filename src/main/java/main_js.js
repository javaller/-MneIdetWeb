jQuery('document').ready(function(){

    jQuery("#driver").on('click', function(){

        var name = jQuery("#name").val();
        jQuery("#stage").load("/MI/src/main/java/result.php", {"name":name} );

        alert(name);
//        var name = jQuery("#name").val();
//        jQuery("#stage").load("/MI/src/main/java/result.php", {"name":name});
//        jQuery("#stage").load("/MI/src/main/java/result.html");
//          jQuery.getJSON("/MI/src/main/java/result.json", function(jd) {
//            jQuery("#stage").html('<p> Name: ' + jd.name + '</p>');
//            jQuery("#stage").append('<p> Age: ' + jd.age + '</p>');
//            jQuery("#stage").append('<p> Sex: ' + jd.sex + '</p>');
//          });

    });

//    jQuery("div:first").width(200);
//    jQuery("div:first").css("background-color", "blue");

//jQuery("li")
//    .eq(2)
//    .css({"color" : "red", "background-color" : "green"});

//    jQuery("p").find("span").addClass("selected");

//    jQuery("li").filter(".middle").addClass("selected");

//    jQuery("li").eq(2).addClass("selected");
});