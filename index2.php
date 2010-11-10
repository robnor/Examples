<?php
	ini_set('display_errors', true); 
	
	class Criteria {
		public $connective;
		public $fieldName;
		public $operation;
		public $values;
	}

	class SearchCriteria {
		public $baseIndex;
		public $criteria;
		public $folderId;
		public $resultSetSize;
	}
	
	class AssetTemplate {
		public $representation;
		public $properties;
	}
	
	class DigitalAsset {
		public $assetProperties;
		public $id;
		public $image;
		public $template;
	}
	
	class AssetProperty {
		public $id;
		public $name;
		public $type;
		public $value;
	}

	class AssetInfo {
		public $fileSize;
		public $format;
		public $height;
		public $width;
		public $folderName;
		public $folderPath;
		public $folderLastPath;
		public $assetHeightByFormat;
		public $assetWidthByFormat;
		public $fileSizeByFormat;
		public $family;
	}
	
	
	// Skapa soapclient 
	$wsClient = new SoapClient("http://ws.c2.se:8080/airport/services/AirportWS?wsdl", array("trace" => 1));
	
	$client = "Coop";
	$userName = "intern_webservice";
	$passWord = "greensome08";
		
	// Loggar in mot webservice
	try {
		$sessionId = $wsClient->login($client,$userName,$passWord);
	} catch (Exception $e) {
		echo "Error: " . $e->getMessage();
	}
		
	$search = "";
	
	//$criteria = array ('values' => $search, 'connective' => -1, 'fieldName' => 98, 'operation' => "like");

	//$searchCriteria = array ('criteria' => $criteria, 'folderId' => 1, 'resultSetSize' => 10);

	//$template = array('properties' => array(90,98), 'representation' => 9);

	$myCriteria->values = $search;
	$myCriteria->connective = -1;
	$myCriteria->fieldName = 98;
	$myCriteria->operation = "like";
	
	$sc = new SearchCriteria();

	$sc->criteria = $myCriteria;
	$sc->folderId = 1;
	$sc->resultSetSize = 100;

	$template = new AssetTemplate();
	$template->representation = 9;
	$template->properties = 98;
			
	try {

		// sätter sökkriteria för vår sökning
		$wsClient->setSearchCriteria($sessionId, $sc,$template);

		
		//while ($wsClient->hasNextSearchResultSet($sessionId)) {

			if(empty($_GET) || $_GET['show'] == 'next') {
				$digitalAssetSet = $wsClient->nextSearchResultSet($sessionId);
			} elseif ($_GET['show'] == 'prev') {
				$digitalAssetSet = $wsClient->previousSearchResultSet($sessionId);
			}

			$output = "<ul>";
			if (!empty($digitalAssetSet)) {
				$assets = $digitalAssetSet->digitalAssets;
				foreach ($assets as $asset) {

					$info = $wsClient->getAssetInfo($sessionId,$asset->id,9);

					$output .= '<li><img src="image.php?id=' . $asset->id .'" alt="" title="' . $info->format . '" /></li>' . "\n";
				}
			}
			$output .= "</ul>";
		//}
		
		$output .= '<div id="navbar">';
		$lowerIndex = $wsClient->getSearchResultSetLowerIndex($sessionId);
		$upperIndex = $wsClient->getSearchResultSetUpperIndex($sessionId);
		echo $lowerIndex . " " . $upperIndex;
		/*if ($wsClient->hasPreviousSearchResultSet($sessionId))
			$output .=  '<a href="index2.php?show=prev">Prev</a>';

		if ($wsClient->hasNextSearchResultSet($sessionId))
			$output .=  '<a href="index2.php?show=next">Next</a>';*/

		$output .= "</div>";
		
		echo "<pre>";
		echo "REQUEST:\n" . htmlspecialchars($wsClient->__getLastRequest()) . "\n";
		echo "</pre>";
		
		
		echo $wsClient->getSearchSize($sessionId);
		
		
	} catch (SoapFault $fault) {
		trigger_error("SOAP Fault: (faultcode: {$fault->faultcode}, faultstring: {$fault->faultstring})", E_USER_ERROR);
	}
	
?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

	<title>Soaptest</title>
	<style media="screen" type="">

		ul {
			padding:12px;
			border:1px solid #ccc;
			overflow:hidden;
			width:700px;
		}

		li {
				margin:0 12px 12px 0;
				padding:12px;
				float:left;
				list-style:none;
				border:1px solid #ccc;
				height:120px;
				width:120px;
				text-align:center;
				cursor:pointer;
		}

		li:hover {
			border:1px solid #333;
		}

		li h2 {
			font-size:12px;
		}


	</style>
	
</head>

<body>
		<?php
			echo $output;

		?>

</body>
</html>
