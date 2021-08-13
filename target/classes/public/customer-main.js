console.log("main page loaded");

window.onload = function(){
    grabAccounts();	
}

function apply_account()
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

	xhr.open("POST", "apply_account");
	xhr.send();
}

function deposit()
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

	xhr.open("POST", "deposit");
	xhr.send();
}

function withdraw()
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

	xhr.open("POST", "withdraw");
	xhr.send();
}

function transfer()
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

	xhr.open("POST", "transfer");
	xhr.send();
}

function receive()
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

	xhr.open("POST", "receive");
	xhr.send();
}

function grabAccounts()
{
    let xhr = new XMLHttpRequest();

    const url = "customer_main";

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
	let accountnameCol = document.createElement("td");
    let approvalCol = document.createElement("td");
	let balanceCol = document.createElement("td");
		
	tableRow.appendChild(accountnameCol);
	tableRow.appendChild(approvalCol);
	tableRow.appendChild(balanceCol);
	table.appendChild(tableRow);
	
	accountnameCol.innerHTML = account.account_name;
	approvalCol.innerHTML = account.approval;
	balanceCol.innerHTML = account.balance;
    	
};