var treeViewApp=angular.module("treeViewApp",['angularTreeview']);

treeViewApp.controller("TreeViewCtrl",function($scope,$http){
	
  	//test tree model 1
    $scope.roleList1 = [
        { "roleName" : "University 1", "roleId" : "role1","collapsed" : true, "children" : [
          { "roleName" : "College 1", "roleId" : "role11", "children" : [] },
          { "roleName" : "College 2", "roleId" : "role12", "children" : []}
        ]},
        { "roleName" : "University 2", "roleId" : "role2", "children" : [
        { "roleName" : "College 3", "roleId" : "role11", "children" : [] },
        { "roleName" : "College 4", "roleId" : "role12", "children" : []}
         ]},

        { "roleName" : "University 3", "roleId" : "role3", "children" : [] }
      ];

  	//test tree model 2
    $scope.roleList2 = [
        { "roleName" : "University 1", "roleId" : "role1","collapsed" : true, "children" : [
          { "roleName" : "college 1", "roleId" : "role11", "collapsed" : true, "children" : [] },
          { "roleName" : "collage 2", "roleId" : "role12", "collapsed" : true, "children" : [
            { "roleName" : "department 1", "roleId" : "role121", "children" : [
              { "roleName" : "Employee 1", "roleId" : "role1211", "children" : [] },
              { "roleName" : "Employee 2", "roleId" : "role1212", "children" : [] }
            ]}
          ]}
        ]},

        { "roleName" : "University 2", "roleId" : "role2", "children" : [
          { "roleName" : "College 3", "roleId" : "role11", "collapsed" : true, "children" : [] },
          { "roleName" : "college 4", "roleId" : "role12", "children" : [
            { "roleName" : "departMent", "roleId" : "role121", "children" : [
              { "roleName" : "Employee 1", "roleId" : "role1211", "children" : [] },
              { "roleName" : "Employee 2", "roleId" : "role1212", "children" : [] }
            ]}
          ]}
        ]}

        /*{ "roleName" : "Guest", "roleId" : "role3", "children" : [
          { "roleName" : "subGuest1", "roleId" : "role11", "children" : [] },
          { "roleName" : "subGuest2", "roleId" : "role12", "collapsed" : true, "children" : [
            { "roleName" : "subGuest2-1", "roleId" : "role121", "children" : [
              { "roleName" : "subGuest2-1-1", "roleId" : "role1211", "children" : [] },
              { "roleName" : "subGuest2-1-2", "roleId" : "role1212", "children" : [] }
            ]}
          ]}
        ]}*/
      ];

      
      
    //roleList1 to treeview
    $scope.roleList = $scope.roleList1;
  
	
});