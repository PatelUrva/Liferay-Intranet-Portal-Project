<%@ include file="init.jsp" %>

<div class="lfr-layout-structure-item-292166ce-9f73-8279-5ae9-7ba7b7044402 lfr-layout-structure-item-row " style="">
  <div class="row align-items-lg-start align-items-sm-start align-items-start align-items-md-start flex-lg-row flex-sm-row flex-row flex-md-row">
   <div class="col col-lg-1 col-sm-12 col-12 col-md-1">
    <a href="http://localhost:8080/web/developer/apply-leave" style="color: inherit; text-decoration: none;" target="">
     <div class="lfr-layout-structure-item-84cf6a33-2994-679f-bfa7-04f64459f34d lfr-layout-structure-item-container " style="">
      <div class="lfr-layout-structure-item-basic-component-heading lfr-layout-structure-item-2cf7a039-3e66-82d8-a09d-007e743e4652 " style="">
       <div id="fragment-d4b9712d-5bd3-6b4a-dd14-7331b3bd7b55">
        <h5 class="component-heading mb-0 text-break" data-lfr-editable-id="element-text" data-lfr-editable-type="text">Compensatory Off</h5>
       </div>
      </div>
      <div class="lfr-layout-structure-item-basic-component-image lfr-layout-structure-item-10396079-54cc-9f13-a623-dcb2fcad4037 " style="">
       <div id="fragment-1498bfff-852a-6b0a-5a04-1760c639098e">
        <div class="component-image overflow-hidden"><picture data-fileentryid="64927">
          <source media="(max-width:300px)" srcset="/o/adaptive-media/image/64927/Thumbnail-300x300/leave.png?t=1676752848721">
          <source media="(max-width:512px) and (min-width:300px)" srcset="/o/adaptive-media/image/64927/Preview-1000x0/leave.png?t=1676752848721">
          <img alt="" class="w-100" data-lfr-editable-id="image-square" data-lfr-editable-type="image" src="/documents/d/developer/leave-png?download=true" data-fileentryid="64927">
         </picture>
        </div>
       </div>
      </div>
      <div class="lfr-layout-structure-item-basic-component-paragraph lfr-layout-structure-item-30136375-b928-8223-5406-fe7cd07d78bc " style="">
       <div id="fragment-fbfb8540-af91-783d-2a0f-f1fec1bfe9ff">
        <div class="clearfix component-paragraph text-break" data-lfr-editable-id="element-text" data-lfr-editable-type="rich-text">
         Available : ${leaveTracker.totalCompen}
        </div>
       </div>
       <style>.component-paragraph img {
	max-width: 100%;
}</style>
      </div>
      <div class="lfr-layout-structure-item-basic-component-paragraph lfr-layout-structure-item-8b54b331-ae26-38b2-fe04-62c748ce1548 " style="">
       <div id="fragment-ade94aa4-b003-b46a-801a-0e272044dc39">
        <div class="clearfix component-paragraph text-break" data-lfr-editable-id="element-text" data-lfr-editable-type="rich-text">
         Booked&nbsp; &nbsp;: ${leaveTracker.bookedCompen}
        </div>
       </div>
      </div>
     </div></a>
   </div>
   <div class="col col-lg-2 col-sm-12 col-12 col-md-2">
    <a href="http://localhost:8080/web/developer/apply-leave" style="color: inherit; text-decoration: none;" target="">
     <div class="lfr-layout-structure-item-3ad0ac6a-bcbe-b703-e50d-a561c09544f7 lfr-layout-structure-item-container " style="">
      <div class="lfr-layout-structure-item-basic-component-heading lfr-layout-structure-item-ea04b6dd-be85-120b-a02d-f9eab7ff3967 " style="">
       <div id="fragment-952ae3df-ff3e-40da-c5d9-28047660f4b0">
        <h5 class="component-heading mb-0 text-break" data-lfr-editable-id="element-text" data-lfr-editable-type="text">Earned Leave</h5>
       </div>
       <style>.fragment-heading-text-colored a {
	color: inherit;
}</style>
      </div>
      <div class="lfr-layout-structure-item-basic-component-image lfr-layout-structure-item-18e8039e-72ef-37d7-f240-a12d5b2aa0eb " style="">
       <div id="fragment-600f80a3-e721-bb19-3e4c-b84746d3f8b0">
        <div class="component-image overflow-hidden">
        <picture data-fileentryid="64946">
          <source media="(max-width:300px)" srcset="/o/adaptive-media/image/64946/Thumbnail-300x300/earned.png?t=1676752961562">
          <source media="(max-width:512px) and (min-width:300px)" srcset="/o/adaptive-media/image/64946/Preview-1000x0/earned.png?t=1676752961562">
          <img alt="" class="w-100" data-lfr-editable-id="image-square" data-lfr-editable-type="image" src="/documents/d/developer/earned-png?download=true" data-fileentryid="64946">
         </picture>
        </div>
       </div>
      </div>
      <div class="lfr-layout-structure-item-basic-component-paragraph lfr-layout-structure-item-24ec57bb-9db9-17df-ca2f-1de9ad949455 " style="">
       <div id="fragment-a879a493-fdfc-2a44-afbc-bd019fb945a9">
        <div class="clearfix component-paragraph text-break" data-lfr-editable-id="element-text" data-lfr-editable-type="rich-text">
         Available : ${leaveTracker.totalEarned}
        </div>
       </div>
       <style>.component-paragraph img {
	max-width: 100%;
}</style>
      </div>
      <div class="lfr-layout-structure-item-basic-component-paragraph lfr-layout-structure-item-c9de426a-afeb-eba6-c5ec-9131cee247c3 " style="">
       <div id="fragment-391f7b90-0813-1388-8ff5-de287ca30534">
        <div class="clearfix component-paragraph text-break" data-lfr-editable-id="element-text" data-lfr-editable-type="rich-text">
         Booked&nbsp; &nbsp;:&nbsp; ${leaveTracker.bookedEarned}
        </div>
       </div>
      </div>
     </div></a>
   </div>
   <div class="col col-lg-2 col-sm-12 col-12 col-md-2">
    <a href="http://localhost:8080/web/developer/apply-leave" style="color: inherit; text-decoration: none;" target="">
     <div class="lfr-layout-structure-item-e2e074a3-156f-402d-cba7-2f4e54ec777e lfr-layout-structure-item-container " style="">
      <div class="lfr-layout-structure-item-basic-component-heading lfr-layout-structure-item-4953ffb1-8266-4135-8adc-80fb9ecc5d94 " style="">
       <div id="fragment-09e77744-b28d-1bc9-2ad7-67731587db1a">
        <h5 class="component-heading mb-0 text-break" data-lfr-editable-id="element-text" data-lfr-editable-type="text">Floater Holidays</h5>
       </div>
       <style>.fragment-heading-text-colored a {
	color: inherit;
}</style>
      </div>
      <div class="lfr-layout-structure-item-basic-component-image lfr-layout-structure-item-c9e6d5ed-fa33-3a38-a970-146514570eab " style="">
       <div id="fragment-38bf5bc7-cf69-e7dc-380b-e63c70a486f3">
        <div class="component-image overflow-hidden"><picture data-fileentryid="64963">
          <source media="(max-width:300px)" srcset="/o/adaptive-media/image/64963/Thumbnail-300x300/holiday.png?t=1676753051143">
          <source media="(max-width:512px) and (min-width:300px)" srcset="/o/adaptive-media/image/64963/Preview-1000x0/holiday.png?t=1676753051143">
          <img alt="" class="w-100" data-lfr-editable-id="image-square" data-lfr-editable-type="image" src="/documents/d/developer/holiday-png?download=true" data-fileentryid="64963">
         </picture>
        </div>
       </div>
      </div>
      <div class="lfr-layout-structure-item-basic-component-paragraph lfr-layout-structure-item-1bdbbfc3-7a06-01f1-9837-10c99c8dfe6c " style="">
       <div id="fragment-1ef9360d-ce6e-2ae1-d1f9-81afd712a92a">
        <div class="clearfix component-paragraph text-break" data-lfr-editable-id="element-text" data-lfr-editable-type="rich-text">
         Available : ${leaveTracker.totalFloater}
        </div>
       </div>
       <style>.component-paragraph img {
	max-width: 100%;
}</style>
      </div>
      <div class="lfr-layout-structure-item-basic-component-paragraph lfr-layout-structure-item-f9827e86-e6aa-6df8-a5b2-03f928473ddd " style="">
       <div id="fragment-2e70684b-80a1-7976-5e5c-a92aa3825422">
        <div class="clearfix component-paragraph text-break" data-lfr-editable-id="element-text" data-lfr-editable-type="rich-text">
         Booked&nbsp; &nbsp;: ${leaveTracker.bookedFloater}
        </div>
       </div>
      </div>
     </div></a>
   </div>
   <div class="col col-lg-7 col-sm-12 col-12 col-md-7">
    <a href="http://localhost:8080/web/developer/apply-leave" style="color: inherit; text-decoration: none;" target="">
     <div class="lfr-layout-structure-item-e2a5c1c0-22fb-7ee3-0aa8-9bc1ca1c95cc lfr-layout-structure-item-container " style="">
      <div class="lfr-layout-structure-item-basic-component-heading lfr-layout-structure-item-58d9621d-2763-abbe-5378-6413a521580e " style="">
       <div id="fragment-3b575e85-b23d-7048-abb9-01afac09073d">
        <h5 class="component-heading mb-0 text-break" data-lfr-editable-id="element-text" data-lfr-editable-type="text">Unpaid Leave</h5>
       </div>
       <style>.fragment-heading-text-colored a {
	color: inherit;
}</style>
      </div>
      <div class="lfr-layout-structure-item-basic-component-image lfr-layout-structure-item-418f19eb-5c6f-0b18-c14d-cb039f8f99f8 " style="">
       <div id="fragment-4aab22ee-2469-c1f8-2bc6-c7d6fac79187">
        <div class="component-image overflow-hidden"><picture data-fileentryid="64980">
          <source media="(max-width:300px)" srcset="/o/adaptive-media/image/64980/Thumbnail-300x300/unpaid.png?t=1676753109319">
          <source media="(max-width:512px) and (min-width:300px)" srcset="/o/adaptive-media/image/64980/Preview-1000x0/unpaid.png?t=1676753109319">
          <img alt="" class="w-100" data-lfr-editable-id="image-square" data-lfr-editable-type="image" src="/documents/d/developer/unpaid-png?download=true" data-fileentryid="64980">
         </picture>
        </div>
       </div>
      </div>
      <div class="lfr-layout-structure-item-basic-component-paragraph lfr-layout-structure-item-0175e80b-176b-c390-dd51-e9af97afb0b8 " style="">
       <div id="fragment-8e161898-26a0-b9eb-a2ee-c7c15c995b70">
        <div class="clearfix component-paragraph text-break" data-lfr-editable-id="element-text" data-lfr-editable-type="rich-text">
         Available : ${leaveTracker.totalUnpaid}
        </div>
       </div>
       <style>.component-paragraph img {
	max-width: 100%;
}</style>
      </div>
      <div class="lfr-layout-structure-item-basic-component-paragraph lfr-layout-structure-item-d4bfed1d-1ea0-9bf3-97bd-a9b016ae728a " style="">
       <div id="fragment-c7e62820-397f-a920-4a02-52d93d8f811b">
        <div class="clearfix component-paragraph text-break" data-lfr-editable-id="element-text" data-lfr-editable-type="rich-text">
         Booked&nbsp; &nbsp;:&nbsp; ${leaveTracker.bookedUnpaid}
        </div>
       </div>
      </div>
     </div></a>
   </div>
  </div>
 </div>
 