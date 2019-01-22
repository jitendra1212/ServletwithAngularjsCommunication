
<html ng-app="products.controller">
<head>
<script src="js/angular.js"></script>
<script>
var app =angular.module("products.controller",[]);
app.controller("products_controller",['$scope','$window','$http',
function($scope,$window,$http){
$scope.productsList=function(){
$window.alert("calling minPrice="+$scope.minPrice+" maxPrice="+$scope.maxPrice);
 $http({
 
 url:"/ServletWithangularjsCommunication/searchProducts",
 method:"get",
 params:{
 
 "minPrice":$scope.minPrice,
 "maxPrice":$scope.maxPrice
 
 }
 
 
 }).then(function(result){
$scope.jsonProductsList=result.data;
 
 },function(result){
 $window.alert("faield");
 
 });

}




}]);
</script>

</head>
<body ng-controller="products_controller">
<div>
MinPrice: <input type="text" ng-model="minPrice"/><br>
MaxPrice: <input type="text" ng-model="maxPrice"/> <br>
<button ng-click="productsList()">search</button>
</div>
<div>
<table border="1">
<tr>
<th>ProductId</th><th>ProductName</th><th>Price</th><th>Qty</th></tr>
<tr ng-repeat="product in jsonProductsList">
<td>{{product.productId}}</td>
<td>{{product.productName}}</td>
<td>{{product.price}}</td>
<td>{{product.qty}}</td>
</tr>

</table>

</div>
</body>
</html>