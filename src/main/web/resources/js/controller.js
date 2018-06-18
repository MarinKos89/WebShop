var cartApp=angular.module("cartApp",[]);

cartApp.controller("cartCtrl",function ($scope,$http) {
    $scope.refreshCart=function () {

        $http.get('/WebShop/rest/cart/'+$scope.cartId).success(function (data) {
            $scope.cart=data;
        });
    };

    $scope.clearCart=function () {
        $http.delete('/WebShop/rest/cart/'+$scope.cartId).success($scope.refreshCart());
    };


    $scope.initCartId=function (cartId) {
        $scope.cartId=cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart=function (productID) {

        $http.put('/WebShop/rest/cart/add/' + productID).success(function () {

            alert("Product successfuly added");
        });
    };

    $scope.removeFromCart=function (productId) {

        $http.put('/WebShop/rest/cart/remove/'+productId).success(function (data) {

            $scope.refreshCart();
        });
    };

    $scope.calculateGrandTotal=function () {
        
        var grandTotal=0;
        for (var i=0;i<$scope.cart.cartItems.length();i++){
            grandTotal+=$scope.cart.cartItems[i].totalPrice;
        }
        return grandTotal;
    }

});