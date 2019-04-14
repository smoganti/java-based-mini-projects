function initialize() {
	completeField = document.getElementById("search");
	completeTable = document.getElementById("complete-table");
	autoRow = document.getElementById("auto-row");
}


function dofill(searchTxt) {
	var url = "autofill?action=findMatch&searchText="+searchTxt;
	var req = initRequest();
	req.onreadystatechange = function(){handleResponse(req)};
	req.open("GET", url, true);
	req.send(null);

}

function initRequest() {
	if (window.XMLHttpRequest) {
		isIE = false;
		if (navigator.userAgent.indexOf('MSIE') != -1) {
			isIE = true;
		}
		return (new XMLHttpRequest());
	} else if (window.ActiveXObject) {
		isIE = true;
		return (new ActiveXObject("Microsoft.XMLHTTP"));
	}
}

function appendProduct(productName,productId) {
	var row;
	var cell;
	var linkElement;
	if (isIE) {
		completeTable.style.display = 'block';
		row = completeTable.insertRow(completeTable.rows.length);
		cell = row.insertCell(0);
	} else {
		completeTable.style.display = 'table';
		row = document.createElement("tr");
		cell = document.createElement("td");
		row.appendChild(cell);
		completeTable.appendChild(row);
	}
	row.className = "popupRow";
	cell.className = "popupCell";
	linkElement = document.createElement("a");
	linkElement.className = "popupItem";
	linkElement.setAttribute("href", "autofill?action=lookup&productId="+productId);
	linkElement.appendChild(document.createTextNode(productName));
	cell.appendChild(linkElement);
}


function parseMessages(responseXML) {
// no matches returned
	if (responseXML == null) {
		return false;
	} else {
		var products = responseXML.getElementsByTagName("products")[0];
		if (products.childNodes.length > 0) {
			completeTable.setAttribute("bordercolor", "black");
			completeTable.setAttribute("border", "1");
			for (loop = 0; loop < products.childNodes.length; loop++) {
				var product = products.childNodes[loop];
				var productName = product.getElementsByTagName("productName")[0];
				var productId = product.getElementsByTagName("id")[0];
				appendProduct(productName.childNodes[0].nodeValue,productId.childNodes[0].nodeValue);
			}
		}
	}
}


function handleResponse(req) {
	clearTable();
	if (req.readyState == 4) {
		if (req.status == 200) {
			parseMessages(req.responseXML);
		}
	}
}

function clearTable() {
	if (completeTable.getElementsByTagName("tr").length > 0) {
		completeTable.style.display = 'none';
		for (loop = completeTable.childNodes.length -1; loop >= 0 ; loop--) {
			completeTable.removeChild(completeTable.childNodes[loop]);
		}
	}
}
