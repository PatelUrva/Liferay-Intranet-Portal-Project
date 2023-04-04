<%@ include file="init.jsp" %>
<div class="container" style="display: flex;">
	<div class="row">
		<div class="col-md-3" style="padding-top: 20px;">
			<div class="card" style="width: 10rem">
				<a href="http://localhost:8080/group/employee/apply-leave">
					<h2 class="card-title" style="text-align: center;padding: 10px;background: lightgray;">Compensatory Off</h2>
				    <div class="component-image overflow-hidden" style="padding: 60px 60px 40px 48px;">
				    	<picture data-fileentryid="64927">
					        <source media="(max-width:300px)" srcset="/o/adaptive-media/image/64927/Thumbnail-300x300/leave.png?t=1676752848721">
					        <source media="(max-width:512px) and (min-width:100px)" srcset="/o/adaptive-media/image/64927/Preview-1000x0/leave.png?t=1676752848721">
					        <img alt="" style="height: 65px;width: 65px;padding-left: 0px;" class="card-img-top" data-lfr-editable-id="image-square" data-lfr-editable-type="image" src="/documents/d/developer/leave-png?download=true" data-fileentryid="64927">
				       </picture>
				    </div>
				    <hr style=" margin: 0;">
				     </a>
				  	<div class="card-body" style="padding-left:18px">
					    <p class="card-text">
					    	Available : ${leaveTracker.totalCompen} 
					   	</p> 
					   	 <p class="card-text">
					    	Booked : ${leaveTracker.bookedCompen} 
					   	</p>
				  	</div>
			 
			</div>
		</div>
		<div class="col-md-3" style="padding-top: 20px;">
			<div class="card" style="width: 10rem">
			<a href="http://localhost:8080/group/employee/apply-leave">
				<h2 class="card-title" style="text-align: center;padding: 10px;background: lightgray;">Earned Leave</h2>
			    <div class="component-image overflow-hidden" style="padding: 60px 60px 40px 48px;">
			    	<picture data-fileentryid="64946">
				        <source media="(max-width:300px)" srcset="/o/adaptive-media/image/64946/Thumbnail-300x300/earned.png?t=1676752961562">
				        <source media="(max-width:512px) and (min-width:100px)" srcset="/o/adaptive-media/image/64946/Preview-1000x0/earned.png?t=1676752961562">
				        <img alt="" style="height: 65px;width: 65px;padding-left: 0px;" class="card-img-top" data-lfr-editable-id="image-square" data-lfr-editable-type="image" src="/documents/d/developer/earned-png?download=true" data-fileentryid="64927">
			       </picture>
			      </div>
			      <hr style=" margin: 0;">
			      </a>
			  <div class="card-body" style="padding-left:18px">
			    <p class="card-text">
			    	Available : ${leaveTracker.totalEarned} 
			   	</p> 
			   	 <p class="card-text">
			    	Booked : ${leaveTracker.bookedEarned} 
			   	</p>
			  </div>
			
			</div>
		</div>
		<div class="col-md-3" style="padding-top: 20px;">
			<div class="card" style="width: 10rem">
			<a href="http://localhost:8080/group/employee/apply-leave">
				<h2 class="card-title" style="text-align: center;padding: 10px;background: lightgray;">Floater Holidays</h2>
			    <div class="component-image overflow-hidden" style="padding: 60px 60px 40px 48px;">
			    	<picture data-fileentryid="64963">
				        <source media="(max-width:300px)" srcset="/o/adaptive-media/image/64963/Thumbnail-300x300/holiday.png?t=1676753051143">
				        <source media="(max-width:512px) and (min-width:100px)" srcset="/o/adaptive-media/image/64963/Preview-1000x0/holiday.png?t=1676753051143">
				        <img alt="" style="height: 65px;width: 65px;padding-left: 0px;" class="card-img-top" data-lfr-editable-id="image-square" data-lfr-editable-type="image" src="/documents/d/developer/holiday-png?download=true" data-fileentryid="64927">
			       </picture>
			      </div>
			      <hr style=" margin: 0;">
			      </a>
			  <div class="card-body" style="padding-left:18px">
			    <p class="card-text">
			    	Available : ${leaveTracker.totalFloater} 
			   	</p> 
			   	 <p class="card-text">
			    	Booked : ${leaveTracker.bookedFloater} 
			   	</p>
			  </div>
			
			</div>
		</div>
		<div class="col-md-3" style="padding-top: 20px;">
			<div class="card" style="width: 10rem">
			<a href="http://localhost:8080/group/employee/apply-leave">
				<h2 class="card-title" style="text-align: center;padding: 10px;background: lightgray;">Unpaid Leave</h2>
			    <div class="component-image overflow-hidden" style="padding: 60px 60px 40px 48px;">
			    	<picture data-fileentryid="64980">
				        <source media="(max-width:300px)" srcset="/o/adaptive-media/image/64980/Thumbnail-300x300/unpaid.png?t=1676753109319">
				        <source media="(max-width:512px) and (min-width:100px)" srcset="/o/adaptive-media/image/64980/Preview-1000x0/unpaid.png?t=1676753109319">
				        <img alt="" style="height: 65px;width: 65px;padding-left: 0px;" class="card-img-top" data-lfr-editable-id="image-square" data-lfr-editable-type="image" src="/documents/d/developer/unpaid-png?download=true" data-fileentryid="64927">
			       </picture>
			      </div>
			      
			   <hr style=" margin: 0;">
			   </a>
			  <div class="card-body" style="padding-left:18px">
			    <p class="card-text">
			    	Available : ${leaveTracker.totalUnpaid} 
			   	</p> 
			   	 <p class="card-text">
			    	Booked : ${leaveTracker.bookedUnpaid} 
			   	</p>
			  </div>
			
			</div>
		</div>
	</div>
</div>



 
