<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Brand;
use Validator;
class BrandController extends BaseController
{
    
    public function index() {
        try {
            $brand = Brand::all();
            return $this->sendResponse($brand, "Márkák betöltve.");
        } catch (\Throwable $th) {
            return $this->sendError("Márkák betöltése sikertelen", $th);
        }
    }
    public function show( $id ) { 
        try {
            $brand = Brand::find( $id );
            return $this->sendResponse($brand, "Márka betöltése sikeres.");
        } catch (\Throwable $th) {
            return $this->sendResponse("Márka betöltése sikertelen.",$th);
        }
    }
    public function create( Request $request ) {
        $validator = Validator::make($request->all(), [
            'name' => 'required'
        ]);
        try {
            $brand = Brand::create($request->all());
            return $this->sendResponse($brand, "Márka létrehozása sikeres");
        } catch (\Throwable $th) {
            return $this->sendError("Márka létrehozása sikertelen", $th);
        }
    }

    public function update( Request $request, $id ) { 
        try {
            $brand = Brand::find( $id );
            $brand->update( $request->all() );
            return $this->sendResponse($brand, "Márka módosítása sikeres.");
        } catch (\Throwable $th) {
            return $this->sendResponse("Márka módosítása sikertelen.",$th);
        }
    }

    public function delete( $id ){
        try {
            Brand::destroy($id);
            return $this->sendResponse("", "Márka sikeresen törölve");
        } catch (\Throwable $th) {
            return $this->sendError("Márka törlése sikertelen", $th);
        }
    }
}
