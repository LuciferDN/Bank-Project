console.log("employee main page loaded");

window.onload = function(){
    grabAccounts();	
}

function approve()
{
    let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		switch(xhr.readyState){
			case 0:
				console.log("nothing, not initalized yet!");
				break;
			case 1: 
				console.log("connection established");
				break;
			case 2:
				console.log("request sent");
				break;
			case 3:
				console.log("awaiting request");
				break;
			case 4: 
				console.log(xhr.status)
				
				if(xhr.status == 200){
					grabPlanets();
				}
		}
	}

	xhr.open("POST", "approve");
	xhr.send();
}

function reject()
{
    let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		switch(xhr.readyState){
			case 0:
				console.log("nothing, not initalized yet!");
				break;
			case 1: 
				console.log("connection established");
				break;
			case 2:
				console.log("request sent");
				break;
			case 3:
				console.log("awaiting request");
				break;
			case 4: 
				console.log(xhr.status)
				
				if(xhr.status == 200){
					grabPlanets();
				}
		}
	}

	xhr.open("POST", "reject");
	xhr.send();
}

function grabAccounts()
{
    let xhr = new XMLHttpRequest();

    const url = "employee_main";

    xhr.onreadystatechange = function()
    {
        console.log("onreadystatechange");
        switch(xhr.readyState)
        {
            case 0:
				console.log("nothing, not initalized yet!");
				break;
			case 1: 
				console.log("connection established");
				break;
			case 2:
				console.log("request sent");
				break;
			case 3:
				console.log("awaiting request");
				break;
			case 4: 
                console.log("hello, Im here!!!!!!!")
				console.log(xhr.status)
				
				if(xhr.status == 200)
                {
					console.log(xhr.responseText);
					
					let AccountList = JSON.parse(xhr.responseText);
					
					console.log(AccountList);
					
					AccountList.forEach(
						element => {
							addRow(element);
						}
						
					)
				}
        }
    }

    xhr.open("GET",url);
	xhr.send();
}

function addRow(account){
    console.log("addRow is called");
	
	
	let table = document.getElementById("customer-table")
	
	let tableRow = document.createElement("tr");
    let usernameCol = document.createElement("td");
	let accountnameCol = document.createElement("td");
    let approvalCol = document.createElement("td");
	let balanceCol = document.createElement("td");

	tableRow.appendChild(usernameCol);	
	tableRow.appendChild(accountnameCol);
	tableRow.appendChild(approvalCol);
	tableRow.appendChild(balanceCol);
	table.appendChild(tableRow);
	
    usernameCol.innerHTML = account.username;
	accountnameCol.innerHTML = account.account_name;
	approvalCol.innerHTML = account.approval;
	balanceCol.innerHTML = account.balance;
    	
};