<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Gearbox;
class GearboxController extends Controller
{
    public function index() {
        try {
            $gearbox = Gearbox::all();
            return $this->sendResponse($gearbox, "Váltó típusok betöltve.");
        } catch (\Throwable $th) {
            return $this->sendError("Váltó típusok betöltése sikertelen", $th);
        }
    }

    public function show( Request $request, $id ) { 
        try {
            $gearbox = Gearbox::find( $id );
            return $this->sendResponse($gearbox, "Váltó típusának betöltése sikeres.");
        } catch (\Throwable $th) {
            return $this->sendResponse("Váltó típusának betöltése sikertelen.",$th);
        }
    }
}
