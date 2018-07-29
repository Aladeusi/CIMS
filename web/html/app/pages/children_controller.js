$(document).ready(function(){


$.ajax({
            type: "GET",
            url: 'http://1ce01bde.ngrok.io/api/facility?facilityID=1',
            success: function (data) {

            	document.getElementById('facility').innerHTML='CIMS<br>&nbsp;'+data[0].Name+'<br><br>';
}
             
        }); 


function GetChildren(){

$.ajax({
            type: "GET",
            url: 'http://1ce01bde.ngrok.io/api/facility/children?facilityID=1',
            success: function (data) {

               

             

               var tableBody = '<table class="table table-striped table-bordered" id="DataTables_Table_10" role="grid" aria-describedby="DataTables_Table_10_info">'+
                                            '<thead>'+
                                                '<tr role="row">'+
                                                    '<th style="width: 127px;">S/N</th>'+
                                                    '<th style="width: 198px;">Name</th>'+
                                                    '<th style="width: 92px;">DOB</th>'+
                                                    '<th style="width: 29px;">Parent Name</th>'+
                                                    '<th style="width: 76px;">Parent Number</th>'+
                                                    '<th style="width: 76px;">Emergency Number</th>'+
                                                '</tr>'+
                                            '</thead>'+
                                            '<tbody>';
                //foreach loop in jquery
                $.each(data, function (i, item) {
                	i=i+1;
                    tableBody = tableBody + '<tr role="row" class="odd">'+
                                                    '<td>'+i+'</td>'+
                                                    '<td class="sorting_1">'+item.Name+'</td>'+
                                                    '<td>'+item.DOB+'</td>'+
                                                    '<td>'+item.ParentName+'</td>'+  
                                                    '<td>'+item.ParentNumber+'</td>'+
                                                    '<td>'+item.EmergencyNumber+'</td>'+ 
                                                '</tr>';
                    
                });

                tableBody = tableBody +'</tbody>'+
                                            '<tfoot>'+
                                                '<tr role="row">'+
                                                    '<th style="width: 127px;">S/N</th>'+
                                                   '<th style="width: 198px;">Name</th>'+
                                                    '<th style="width: 92px;">DOB</th>'+
                                                    '<th style="width: 29px;">Parent Name</th>'+
                                                    '<th style="width: 76px;">Parent Number</th>'+
                                                    '<th style="width: 76px;">Emergency Number</th>'+

                                                '</tr>'+
                                            '</tfoot>'+
                                        '</table>';

              // window.alert(tableBody);

               $("#display_children").html(tableBody);


               
                //window.alert(data.length);

               //trigger new child alert
               var number_of_children=data.length;
               var number_prev_tracked=document.getElementById("display_count").textContent;
                //window.alert(number_prev_tracked);

               if(number_of_children > number_prev_tracked){
               	 var diff=number_of_children - number_prev_tracked;

               	 if(diff==1){
               	 	var message="Record of a new child added";

               	 }else{



               	 	var message="Record of "+diff+" new children added";

               	 }

              

               	 	window.alert(message);
              

               	 
               }

               document.getElementById("display_count").innerHTML = data.length;


                  // window.alert(data.length);


               

              // $('#display_count').html(NewCount);



            }
        }); 





}


//10 secs
setInterval(function (){GetChildren();}, 5000);


});

