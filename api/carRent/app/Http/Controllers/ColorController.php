<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Color;
class ColorController extends Controller
{
    public function index() {
        try {
            $color = Color::all();
            return $this->sendResponse($color, "Színek betöltve.");
        } catch (\Throwable $th) {
            return $this->sendError("Színek betöltése sikertelen", $th);
        }
    }
    public function show( Request $request, $id ) { 
        try {
            $color = Color::find( $id );
            return $this->sendResponse($color, "Szín betöltése sikeres.");
        } catch (\Throwable $th) {
            return $this->sendResponse("Szín betöltése sikertelen.",$th);
        }
    }
    public function store( Request $request ) {
        try {
            $color = Color::create($request->all());
            return $this->sendResponse($color, "Szín létrehozása sikeres");
        } catch (\Throwable $th) {
            return $this->sendError("Szín létrehozása sikertelen", $th);
        }
    }

    public function update( Request $request, $id ) { 
        try {
            $color = Color::find( $id );
            $color->update( $request->all() );
            return $this->sendResponse($color, "Szín módosítása sikeres.");
        } catch (\Throwable $th) {
            return $this->sendResponse("Szín módosítása sikertelen.",$th);
        }
    }

    public function delete( $id ){
        try {
            Color::destroy($id);
            return $this->sendResponse("", "Szín sikeresen törölve");
        } catch (\Throwable $th) {
            return $this->sendError("Szín törlése sikertelen", $th);
        }
    }
}
