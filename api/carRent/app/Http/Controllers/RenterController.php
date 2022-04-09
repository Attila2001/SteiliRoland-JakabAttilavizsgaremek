<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Validator;
use App\Models\Renter;
use App\Http\Resources\Renter as RenterResource;
class RenterController extends BaseController
{
    public function index()
    {
        try {
            $renters=Renter::all();
            return $this->sendResponse($renters, "Bérlők betöltve.");
        } catch (\Throwable $th) {
            return $this->sendError("Bérlők betöltése sikertelen", $th);
        }
            
    }
    public function create(Request $request){
        $validator = Validator::make($request->all(), [
            'name' => 'required',
            'email' => 'required',
            'phone' => 'required',
            'address' => 'required',
            'identify' => 'required',
        ]);
        if ($validator->fails()) {
            return $this->sendError("Hibás érvényesítés", $validator->errors());
        }
        try {
            $renters = Renter::create($request->all());
            return $this->sendResponse($renters, "Bérlő létrehozása sikeres");
        } catch (\Throwable $th) {
            return $this->sendError("Bérlő létrehozása sikertelen", $th);
        }
    }
    public function show($id){
        
        try {
            $renters=Renter::find($id);
            return $this->sendResponse($renters, "Bérlő betöltve.");
        } catch (\Throwable $th) {
            return $this->sendError("Bérlő betöltése sikertelen", $th);
        }
    }
    public function update(Request $request,$id){
        try {
            $renters=Renter::find($id);
            $renters->update( $request->all() );
            return $this->sendResponse($renters, "Bérlő módosítása sikeres.");
        } catch (\Throwable $th) {
            return $this->sendError("Bérlő módosítása sikertelen", $th);
        }
    }
    public function delete($id){
        try {
            Renter::destroy($id);
            return $this->sendResponse("", "Bérlő sikeresen törölve");
        } catch (\Throwable $th) {
            return $this->sendError("Bérlő törlése sikertelen", $th);
        }
    }
}
