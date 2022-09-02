'use strict';
angular.module('carrots_bangbang')
    .controller('companyCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, companyService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     name: $state.params.name
	                              ,  
                     	     totalNum: $state.params.totalNum
	                              ,  
                     	     industry: $state.params.industry
	                              ,  
                     	     province: $state.params.province
	                              ,  
                     	     city: $state.params.city
	                              ,  
                     	     county: $state.params.county
	                              ,  
                     	     financing: $state.params.financing
	                              ,  
                     	     approved: $state.params.approved
	                              ,  
                     	     approvedAt: $state.params.approvedAt
	                	     freezed: $state.params.freezed
	                	     slogan: $state.params.slogan
	                	     introduction: $state.params.introduction
	                	     product: $state.params.product
	                	     moblile: $state.params.moblile
	                	     address: $state.params.address
	                	     logo: $state.params.logo
	                	     mail: $state.params.mail
	                	     map: $state.params.map
	                	     createAt: $state.params.createAt
	                	     updateAt: $state.params.updateAt
	                	     createBy: $state.params.createBy
	                	     releaseAt: $state.params.releaseAt
	                	     updateBy: $state.params.updateBy
	                         };


    companyService.getList(vm.params).then(function(res) {
        if (res.data.code === 0) {
            vm.list = res.data.data;
            vm.page = {
                next: res.data.next || 0,
                size: res.data.size || 0,
                page: res.data.page || 0,
                total: res.data.total || 0
            };
        } else {
            $rootScope.alert(res.data.message);
        }
    });
  

    vm.search = function() {
        
        $state.go("field.companyList", vm.params,{reload:true});
    };
    });
