<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Validator;
use App\Models\Rent;
use Illuminate\Support\Facades\DB;
class RentController extends BaseController
{
    public function index(){
        try {
            $rents=DB::table('rents')
            ->join('cars', 'rents.car_id', '=', 'cars.id')
            ->join('renters', 'rents.renter_id', '=','renters.id')
            ->select('rents.id', 'rents.startdate', 'rents.enddate', 'rents.deposit',
             'renters.name', 'cars.platenumber')
             ->get();
            return $this->sendResponse($rents, "Bérlések betöltve.");
        } catch (\Throwable $th) {
           return $this->sendError("Bérlések betöltése sikertelen", $th);
        }
    }
    public function create(Request $request){
        $validator = Validator::make($request->all(), [
            'startdate' => 'required',
            'enddate' => 'required',
            'deposit' => 'required',
            'renter_id' => 'required',
            'car_id' => 'required',
        ]);
        if ($validator->fails()) {
            return $this->sendError("Hibás érvényesítés", $validator->errors());
        }
        try {
            $rent = Rent::create($request->all());
            return $this->sendResponse($rent, "Bérlés létrehozása sikeres");
        } catch (\Throwable $th) {
            return $this->sendError("Bérlés létrehozása sikertelen", $th);
        }
    }
    public function show($id){
        try {
            $rent=Rent::find($id);
            return $this->sendResponse($rent, "Bérlés betöltve.");
        } catch (\Throwable $th) {
            return $this->sendError("Bérlés betöltése sikertelen", $th);
        }
    }
    public function update(Request $request,$id){
        try {
            $rent=Rent::find($id);
            $rent->update($request->all());
            return $this->sendResponse($rent, "Bérlés módosítása sikeres.");
        } catch (\Throwable $th) {
            return $this->sendError("Bérlés módosítása sikertelen", $th);
        }
    }
    public function delete($id){
        try {
            Rent::destroy($id);
            return $this->sendResponse("", "Bérlő sikeresen törölve");
        } catch (\Throwable $th) {
            return $this->sendError("Bérlő törlése sikertelen", $th);
        }
    }
}
