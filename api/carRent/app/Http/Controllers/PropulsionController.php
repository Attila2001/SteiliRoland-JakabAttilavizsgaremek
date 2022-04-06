<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Propulsion;
class PropulsionController extends BaseController
{
    public function index() {
        try {
            $propulsion = Propulsion::all();
            return $this->sendResponse($propulsion, "Meghajtás típusok betöltve.");
        } catch (\Throwable $th) {
            return $this->sendError("Meghajtás típusok betöltése sikertelen", $th);
        }
    }

    public function show( Request $request, $id ) { 
        try {
            $propulsion = Propulsion::find( $id );
            return $this->sendResponse($propulsion, "Meghajtás típusának betöltése sikeres.");
        } catch (\Throwable $th) {
            return $this->sendResponse("Meghajtás típusának betöltése sikertelen.",$th);
        }
    }
}
